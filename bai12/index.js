class FoodRatings {
    constructor(foods, cuisines, ratings) {
        this.foodInfo = new Map();       // food -> {cuisine, rating}
        this.cuisineFoods = new Map();   // cuisine -> [foods]

        for (let i = 0; i < foods.length; i++) {
            const food = foods[i];
            const cuisine = cuisines[i];
            const rating = ratings[i];

            this.foodInfo.set(food, { cuisine, rating });

            if (!this.cuisineFoods.has(cuisine)) {
                this.cuisineFoods.set(cuisine, []);
            }
            this.cuisineFoods.get(cuisine).push(food);
        }
    }

    changeRating(food, newRating) {
        const info = this.foodInfo.get(food);
        info.rating = newRating;
    }

    highestRated(cuisine) {
        const foods = this.cuisineFoods.get(cuisine);
        foods.sort((a, b) => {
            const ra = this.foodInfo.get(a).rating;
            const rb = this.foodInfo.get(b).rating;
            if (ra !== rb) return rb - ra;      // rating giảm dần
            return a.localeCompare(b);          // nếu bằng rating thì tên nhỏ hơn
        });
        return foods[0];
    }
}
