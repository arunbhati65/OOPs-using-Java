public enum Hotel {
    Hayat(10000, 15000),
    Radisson(21000, 11000),
    Lowes(20000, 5100);

    private Integer weekDayPrice;
    private Integer weekEndPrice;

    public Integer getWeekDayPrice() {
        return weekDayPrice;
    }

    public Integer getWeekEndPrice() {
        return weekEndPrice;
    }

    Hotel(int weekDay, int weekend) {
        this.weekDayPrice = weekDay;
        this.weekEndPrice = weekend;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "weekDayPrice=" + weekDayPrice +
                ", weekEndPrice=" + weekEndPrice +
                '}';
    }
}
