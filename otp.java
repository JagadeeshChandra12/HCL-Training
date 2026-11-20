import java.util.Random;

public class otp {
    public static void main(String[] args) {
        Random random = new Random();
        int otpCode = 1000 + random.nextInt(9000);

        System.out.println("Generated 4-digit OTP: " + otpCode);
    }
}
