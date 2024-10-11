package com.refactor.practice.movie;

public class NewReleaseMoviePrice implements CalPriceInterface {
    // 每天租赁价格
    private final double basePrice = 3;
    // 常客基本积分
    private final int frequentRenterPoints = 1;
    // 租赁额外积分超时时间
    private final int externalFrequentRenterPointsOverTime = 1;
    // 租赁超时额外积分
    private final int overTimeExternalFrequentRenterPoints = 1;

    @Override
    public double calPrice(int _dayRented) {
        if (_dayRented <= 0) {
            return 0;
        }
        return basePrice * _dayRented;
    }

    @Override
    public int calFrequentRenterPoints(int _dayRented) {
        if (_dayRented <= 0) {
            return 0;
        }
        return frequentRenterPoints + (_dayRented > externalFrequentRenterPointsOverTime ? overTimeExternalFrequentRenterPoints : 0);
    }
}