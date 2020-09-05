import java.time.Duration;

public record Course(String name, Duration duration, int rating) {
    // implicit declaration as above
    public Course{
        if(rating > 5){
            throw new IllegalArgumentException("Input value is above 5, please rate again!");
        }
    }
}
