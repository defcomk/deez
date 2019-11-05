package ZephrTech.NR;

public class IMX481 {
    public static double compute_noise_model_entry_S(int plane, int sens) {
         double noise_model_A[] = { 4.4820701e-006,4.4581704e-006,3.9568277e-006,4.1237364e-006 };
         double noise_model_B[] = { -2.4304206e-005,-9.4979587e-006,-8.9159435e-006,-9.905271e-006 };
        double A = noise_model_A[plane];
        double B = noise_model_B[plane];
        double s = A * sens + B;
        return s < 0.0 ? 0.0 : s;
    }

  public static   double compute_noise_model_entry_O(int plane, int sens) {
         double noise_model_C[] = { 5.9909252e-011,6.1622738e-011,5.7335864e-011,5.2879372e-011 };
         double noise_model_D[] = { 5.0784301e-007,2.7675767e-007,4.6547726e-007,4.9118302e-007 };
        double digital_gain = (sens / 1600.0) < 1.0 ? 1.0 : (sens / 1600.0);
        double C = noise_model_C[plane];
        double D = noise_model_D[plane];
        double o = C * sens * sens + D * digital_gain * digital_gain;
        return o < 0.0 ? 0.0 : o;
    }

}
