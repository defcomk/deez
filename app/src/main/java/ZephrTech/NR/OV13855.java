package ZephrTech.NR;

public class OV13855 {
    static double compute_noise_model_entry_S(int plane, int sens) {
         double noise_model_A[] = { 3.2587999112136427e-06,3.335622447965505e-06,3.367630096187744e-06,4.255424100370726e-06 };
         double noise_model_B[] = { 7.889710045785586e-05,9.46474402103867e-05,9.476400722981725e-05,0.0001344927076722985 };
        double A = noise_model_A[plane];
        double B = noise_model_B[plane];
        double s = A * sens + B;
        return s < 0.0 ? 0.0 : s;
    }

    static  double compute_noise_model_entry_O(int plane, int sens) {
         double noise_model_C[] = { 3.84902242999037e-11,4.2347960695857806e-11,4.313185819246855e-11,3.6435697151450744e-11 };
         double noise_model_D[] = { -1.5178422098151941e-09,-3.624201631355553e-07,-3.6749500949950944e-07,1.0669287183758478e-07 };
        double digital_gain = (sens / 387.0) < 1.0 ? 1.0 : (sens / 387.0);
        double C = noise_model_C[plane];
        double D = noise_model_D[plane];
        double o = C * sens * sens + D * digital_gain * digital_gain;
        return o < 0.0 ? 0.0 : o;
    }
}
