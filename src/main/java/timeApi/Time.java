package timeApi;

public class Time {

    private String $id;
    private String currentDateTime;
    private String utcOffset;
    private boolean isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private long currentFileTime;
    private String ordinalDate;
    private String serviceResponse;

    public Time(String $id, String currentDateTime, String utcOffset,
                boolean isDayLightSavingsTime, String dayOfTheWeek, String timeZoneName,
                long currentFileTime, String ordinalDate, String serviceResponse) {
        this.$id = $id;
        this.currentDateTime = currentDateTime;
        this.utcOffset = utcOffset;
        this.isDayLightSavingsTime = isDayLightSavingsTime;
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeZoneName = timeZoneName;
        this.currentFileTime = currentFileTime;
        this.ordinalDate = ordinalDate;
        this.serviceResponse = serviceResponse;
    }

    public Time() {
    }

    public String get$Id() {
        return $id;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public boolean isDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public long getCurrentFileTime() {
        return currentFileTime;
    }

    public String getOrdinalDate() {
        return ordinalDate;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }


    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @Override
    public String toString() {
        return "Time{" +
                "$id='" + $id + '\'' +
                ", currentDateTime='" + currentDateTime + '\'' +
                ", utcOffset='" + utcOffset + '\'' +
                ", isDayLightSavingsTime=" + isDayLightSavingsTime +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", timeZoneName='" + timeZoneName + '\'' +
                ", currentFileTime=" + currentFileTime +
                ", ordinalDate='" + ordinalDate + '\'' +
                ", serviceResponse='" + serviceResponse + '\'' +
                '}';
    }
}
