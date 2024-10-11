package com.refactor.practice.movie;

public class RegularMoviePrice implements CalPriceInterface {
    // 租赁不超2天总价格
    private final double basePrice = 2;
    // 基本价格租赁最长时间
    private final int basePriceMaxRentDay = 2;
    // 超过2天每天价格
    private final double overTimePirce = 1.5;
    // 常客基本积分
    private final int frequentRenterPoints = 1;

    @Override
    public double calPrice(int _dayRented) {
        if (_dayRented <= 0) {
            return 0;
        }
        if (_dayRented <= basePriceMaxRentDay) {
            return basePrice;
        }

        return basePrice + (_dayRented - basePriceMaxRentDay) * overTimePirce;
    }

    @Override
    public int calFrequentRenterPoints(int _dayRented) {
        if (_dayRented <= 0) {
            return 0;
        }
        return frequentRenterPoints;
    }
}