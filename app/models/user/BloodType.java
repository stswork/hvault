package models.user;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
public enum BloodType {
    A_NEGATIVE ("A-"),
    A_POSITIVE ("A+")
    ;

    private BloodType(final String bloodType) {
        this.bloodType = bloodType;
    }

    private final String bloodType;

    @Override
    public String toString() {
        return bloodType;
    }
}
