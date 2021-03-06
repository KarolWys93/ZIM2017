package DSP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Karol on 20-06-2017.
 */
public class FIRfiltersCoeffs {

    static double[] LOWPASS_11Hz_128fs = {
            -2.0336106e-03,
            -8.3836000e-03,
            -1.7360538e-02,
            -1.8138432e-02,
            6.7985472e-03,
            6.8513136e-02,
            1.5630728e-01,
            2.3593518e-01,
            2.6823519e-01,
            2.3593518e-01,
            1.5630728e-01,
            6.8513136e-02,
            6.7985472e-03,
            -1.8138432e-02,
            -1.7360538e-02,
            -8.3836000e-03,
            -2.0336106e-03,
    };

    static double[] LOWPASS_11Hz_250fs ={
            -4.5041267e-04,
            -1.2883583e-03,
            -2.7851524e-03,
            -4.9197873e-03,
            -7.4107078e-03,
            -9.6107710e-03,
            -1.0505784e-02,
            -8.8299535e-03,
            -3.3024997e-03,
            7.0509184e-03,
            2.2562720e-02,
            4.2668109e-02,
            6.5815638e-02,
            8.9599260e-02,
            1.1110967e-01,
            1.2744459e-01,
            1.3626434e-01,
            1.3626434e-01,
            1.2744459e-01,
            1.1110967e-01,
            8.9599260e-02,
            6.5815638e-02,
            4.2668109e-02,
            2.2562720e-02,
            7.0509184e-03,
            -3.3024997e-03,
            -8.8299535e-03,
            -1.0505784e-02,
            -9.6107710e-03,
            -7.4107078e-03,
            -4.9197873e-03,
            -2.7851524e-03,
            -1.2883583e-03,
            -4.5041267e-04
    };

    static double[] LOWPASS_11Hz_500fs ={
            -2.5955595e-04,
            -3.1536945e-04,
            -4.2033129e-04,
            -4.4180815e-04,
            -2.8803935e-04,
            1.6105333e-04,
            1.0466893e-03,
            2.5220603e-03,
            4.7365871e-03,
            7.8188287e-03,
            1.1856596e-02,
            1.6878680e-02,
            2.2839590e-02,
            2.9610443e-02,
            3.6977257e-02,
            4.4648255e-02,
            5.2270164e-02,
            5.9452539e-02,
            6.5797863e-02,
            7.0934556e-02,
            7.4549482e-02,
            7.6416289e-02,
            7.6416289e-02,
            7.4549482e-02,
            7.0934556e-02,
            6.5797863e-02,
            5.9452539e-02,
            5.2270164e-02,
            4.4648255e-02,
            3.6977257e-02,
            2.9610443e-02,
            2.2839590e-02,
            1.6878680e-02,
            1.1856596e-02,
            7.8188287e-03,
            4.7365871e-03,
            2.5220603e-03,
            1.0466893e-03,
            1.6105333e-04,
            -2.8803935e-04,
            -4.4180815e-04,
            -4.2033129e-04,
            -3.1536945e-04,
            -2.5955595e-04
    };

    static double[] LOWPASS_11Hz_1000fs = {
            -1.2276846e-03,
            -3.6335183e-04,
            -3.6168408e-04,
            -3.1130052e-04,
            -1.9901650e-04,
            -1.0099934e-05,
            2.6936627e-04,
            6.5479185e-04,
            1.1603017e-03,
            1.7994869e-03,
            2.5840383e-03,
            3.5239837e-03,
            4.6266154e-03,
            5.8963162e-03,
            7.3337516e-03,
            8.9357596e-03,
            1.0695002e-02,
            1.2600006e-02,
            1.4635080e-02,
            1.6780368e-02,
            1.9012020e-02,
            2.1302447e-02,
            2.3620982e-02,
            2.5934413e-02,
            2.8208001e-02,
            3.0405920e-02,
            3.2492404e-02,
            3.4431944e-02,
            3.6190867e-02,
            3.7737333e-02,
            3.9043766e-02,
            4.0085730e-02,
            4.0846028e-02,
            4.1306478e-02,
            4.1460970e-02,
            4.1306478e-02,
            4.0846028e-02,
            4.0085730e-02,
            3.9043766e-02,
            3.7737333e-02,
            3.6190867e-02,
            3.4431944e-02,
            3.2492404e-02,
            3.0405920e-02,
            2.8208001e-02,
            2.5934413e-02,
            2.3620982e-02,
            2.1302447e-02,
            1.9012020e-02,
            1.6780368e-02,
            1.4635080e-02,
            1.2600006e-02,
            1.0695002e-02,
            8.9357596e-03,
            7.3337516e-03,
            5.8963162e-03,
            4.6266154e-03,
            3.5239837e-03,
            2.5840383e-03,
            1.7994869e-03,
            1.1603017e-03,
            6.5479185e-04,
            2.6936627e-04,
            -1.0099934e-05,
            -1.9901650e-04,
            -3.1130052e-04,
            -3.6168408e-04,
            -3.6335183e-04,
            -1.2276846e-03
    };

    static double[] HIGHPASS_6Hz_128fs = {
            -1.2456691e-02,
            -8.5938235e-03,
            -1.1269980e-02,
            -1.4271377e-02,
            -1.7546098e-02,
            -2.1027887e-02,
            -2.4651426e-02,
            -2.8337969e-02,
            -3.1989650e-02,
            -3.5507114e-02,
            -3.8797928e-02,
            -4.1773254e-02,
            -4.4342819e-02,
            -4.6426867e-02,
            -4.7962574e-02,
            -4.8905174e-02,
            9.5077694e-01,
            -4.8905174e-02,
            -4.7962574e-02,
            -4.6426867e-02,
            -4.4342819e-02,
            -4.1773254e-02,
            -3.8797928e-02,
            -3.5507114e-02,
            -3.1989650e-02,
            -2.8337969e-02,
            -2.4651426e-02,
            -2.1027887e-02,
            -1.7546098e-02,
            -1.4271377e-02,
            -1.1269980e-02,
            -8.5938235e-03,
            -1.2456691e-02
    };

    static double[] HIGHPASS_6Hz_250fs = {
            -1.1036492e-02,
            -3.8837346e-03,
            -4.5350762e-03,
            -5.2331813e-03,
            -5.9746948e-03,
            -6.7603115e-03,
            -7.5846282e-03,
            -8.4439303e-03,
            -9.3338488e-03,
            -1.0254021e-02,
            -1.1191679e-02,
            -1.2151433e-02,
            -1.3120017e-02,
            -1.4095193e-02,
            -1.5067718e-02,
            -1.6032771e-02,
            -1.6981311e-02,
            -1.7909362e-02,
            -1.8810430e-02,
            -1.9675431e-02,
            -2.0501650e-02,
            -2.1277636e-02,
            -2.2000259e-02,
            -2.2660288e-02,
            -2.3260418e-02,
            -2.3784712e-02,
            -2.4244925e-02,
            -2.4625711e-02,
            -2.4914463e-02,
            -2.5134846e-02,
            -2.5260098e-02,
            9.7469537e-01,
            -2.5260098e-02,
            -2.5134846e-02,
            -2.4914463e-02,
            -2.4625711e-02,
            -2.4244925e-02,
            -2.3784712e-02,
            -2.3260418e-02,
            -2.2660288e-02,
            -2.2000259e-02,
            -2.1277636e-02,
            -2.0501650e-02,
            -1.9675431e-02,
            -1.8810430e-02,
            -1.7909362e-02,
            -1.6981311e-02,
            -1.6032771e-02,
            -1.5067718e-02,
            -1.4095193e-02,
            -1.3120017e-02,
            -1.2151433e-02,
            -1.1191679e-02,
            -1.0254021e-02,
            -9.3338488e-03,
            -8.4439303e-03,
            -7.5846282e-03,
            -6.7603115e-03,
            -5.9746948e-03,
            -5.2331813e-03,
            -4.5350762e-03,
            -3.8837346e-03,
            -1.1036492e-02
    };

    static double[] HIGHPASS_6Hz_500fs = {
            -9.4236565e-03,
            -1.6871311e-03,
            -1.8339619e-03,
            -1.9879023e-03,
            -2.1467468e-03,
            -2.3125875e-03,
            -2.4829863e-03,
            -2.6599653e-03,
            -2.8410011e-03,
            -3.0287663e-03,
            -3.2201767e-03,
            -3.4184411e-03,
            -3.6194481e-03,
            -3.8270369e-03,
            -4.0382314e-03,
            -4.2538472e-03,
            -4.4730994e-03,
            -4.6965820e-03,
            -4.9215967e-03,
            -5.1502539e-03,
            -5.3810240e-03,
            -5.6151572e-03,
            -5.8504063e-03,
            -6.0888962e-03,
            -6.3280575e-03,
            -6.5693636e-03,
            -6.8104083e-03,
            -7.0521123e-03,
            -7.2911368e-03,
            -7.5305518e-03,
            -7.7673626e-03,
            -8.0061441e-03,
            -8.2422398e-03,
            -8.4790418e-03,
            -8.7083046e-03,
            -8.9345388e-03,
            -9.1524920e-03,
            -9.3805786e-03,
            -9.5961160e-03,
            -9.8017004e-03,
            -1.0013079e-02,
            -1.0210583e-02,
            -1.0407208e-02,
            -1.0594172e-02,
            -1.0776945e-02,
            -1.0950449e-02,
            -1.1118442e-02,
            -1.1277311e-02,
            -1.1429779e-02,
            -1.1573107e-02,
            -1.1707059e-02,
            -1.1834702e-02,
            -1.1949710e-02,
            -1.2056567e-02,
            -1.2155168e-02,
            -1.2242973e-02,
            -1.2320307e-02,
            -1.2387878e-02,
            -1.2446178e-02,
            -1.2493919e-02,
            -1.2531124e-02,
            -1.2556840e-02,
            -1.2572054e-02,
            9.8742325e-01,
            -1.2572054e-02,
            -1.2556840e-02,
            -1.2531124e-02,
            -1.2493919e-02,
            -1.2446178e-02,
            -1.2387878e-02,
            -1.2320307e-02,
            -1.2242973e-02,
            -1.2155168e-02,
            -1.2056567e-02,
            -1.1949710e-02,
            -1.1834702e-02,
            -1.1707059e-02,
            -1.1573107e-02,
            -1.1429779e-02,
            -1.1277311e-02,
            -1.1118442e-02,
            -1.0950449e-02,
            -1.0776945e-02,
            -1.0594172e-02,
            -1.0407208e-02,
            -1.0210583e-02,
            -1.0013079e-02,
            -9.8017004e-03,
            -9.5961160e-03,
            -9.3805786e-03,
            -9.1524920e-03,
            -8.9345388e-03,
            -8.7083046e-03,
            -8.4790418e-03,
            -8.2422398e-03,
            -8.0061441e-03,
            -7.7673626e-03,
            -7.5305518e-03,
            -7.2911368e-03,
            -7.0521123e-03,
            -6.8104083e-03,
            -6.5693636e-03,
            -6.3280575e-03,
            -6.0888962e-03,
            -5.8504063e-03,
            -5.6151572e-03,
            -5.3810240e-03,
            -5.1502539e-03,
            -4.9215967e-03,
            -4.6965820e-03,
            -4.4730994e-03,
            -4.2538472e-03,
            -4.0382314e-03,
            -3.8270369e-03,
            -3.6194481e-03,
            -3.4184411e-03,
            -3.2201767e-03,
            -3.0287663e-03,
            -2.8410011e-03,
            -2.6599653e-03,
            -2.4829863e-03,
            -2.3125875e-03,
            -2.1467468e-03,
            -1.9879023e-03,
            -1.8339619e-03,
            -1.6871311e-03,
            -9.4236565e-03
    };

    static double[] HIGHPASS_6Hz_1000fs = {
            -9.3625753e-03,
            -8.3174520e-04,
            -8.6844401e-04,
            -9.0545263e-04,
            -9.4359410e-04,
            -9.8191779e-04,
            -1.0214818e-03,
            -1.0613312e-03,
            -1.1023162e-03,
            -1.1435771e-03,
            -1.1860089e-03,
            -1.2287387e-03,
            -1.2727172e-03,
            -1.3170280e-03,
            -1.3625714e-03,
            -1.4084261e-03,
            -1.4554163e-03,
            -1.5031361e-03,
            -1.5516253e-03,
            -1.6002816e-03,
            -1.6502441e-03,
            -1.7001005e-03,
            -1.7506988e-03,
            -1.8010978e-03,
            -1.8528413e-03,
            -1.9039197e-03,
            -1.9565053e-03,
            -2.0086666e-03,
            -2.0628240e-03,
            -2.1166756e-03,
            -2.1728019e-03,
            -2.2281725e-03,
            -2.2856394e-03,
            -2.3410494e-03,
            -2.3982054e-03,
            -2.4518545e-03,
            -2.5089139e-03,
            -2.5638986e-03,
            -2.6318671e-03,
            -2.6876762e-03,
            -2.7402675e-03,
            -2.8053242e-03,
            -2.8613499e-03,
            -2.9229264e-03,
            -2.9808737e-03,
            -3.0420922e-03,
            -3.1008681e-03,
            -3.1620227e-03,
            -3.2213633e-03,
            -3.2826243e-03,
            -3.3423669e-03,
            -3.4037197e-03,
            -3.4636027e-03,
            -3.5248263e-03,
            -3.5845127e-03,
            -3.6456370e-03,
            -3.7054255e-03,
            -3.7657025e-03,
            -3.8256031e-03,
            -3.8860202e-03,
            -3.9454176e-03,
            -4.0053697e-03,
            -4.0648571e-03,
            -4.1244864e-03,
            -4.1830810e-03,
            -4.2418239e-03,
            -4.2995515e-03,
            -4.3575375e-03,
            -4.4146502e-03,
            -4.4721534e-03,
            -4.5288779e-03,
            -4.5858088e-03,
            -4.6414946e-03,
            -4.6967891e-03,
            -4.7503950e-03,
            -4.8045541e-03,
            -4.8587202e-03,
            -4.9131637e-03,
            -4.9621851e-03,
            -5.0159063e-03,
            -5.0661198e-03,
            -5.1165141e-03,
            -5.1657665e-03,
            -5.2146885e-03,
            -5.2623347e-03,
            -5.3095165e-03,
            -5.3554157e-03,
            -5.4008522e-03,
            -5.4449981e-03,
            -5.4886879e-03,
            -5.5310648e-03,
            -5.5728880e-03,
            -5.6133708e-03,
            -5.6531863e-03,
            -5.6921359e-03,
            -5.7292580e-03,
            -5.7660135e-03,
            -5.8017840e-03,
            -5.8357291e-03,
            -5.8689752e-03,
            -5.9012242e-03,
            -5.9327547e-03,
            -5.9625492e-03,
            -5.9916075e-03,
            -6.0189873e-03,
            -6.0456415e-03,
            -6.0705822e-03,
            -6.0947959e-03,
            -6.1173590e-03,
            -6.1393163e-03,
            -6.1595002e-03,
            -6.1789184e-03,
            -6.1961270e-03,
            -6.2128619e-03,
            -6.2281816e-03,
            -6.2430585e-03,
            -6.2545653e-03,
            -6.2660878e-03,
            -6.2765845e-03,
            -6.2846900e-03,
            -6.2923362e-03,
            -6.2982769e-03,
            -6.3031461e-03,
            -6.3064668e-03,
            -6.3085648e-03,
            9.9369080e-01,
            -6.3085648e-03,
            -6.3064668e-03,
            -6.3031461e-03,
            -6.2982769e-03,
            -6.2923362e-03,
            -6.2846900e-03,
            -6.2765845e-03,
            -6.2660878e-03,
            -6.2545653e-03,
            -6.2430585e-03,
            -6.2281816e-03,
            -6.2128619e-03,
            -6.1961270e-03,
            -6.1789184e-03,
            -6.1595002e-03,
            -6.1393163e-03,
            -6.1173590e-03,
            -6.0947959e-03,
            -6.0705822e-03,
            -6.0456415e-03,
            -6.0189873e-03,
            -5.9916075e-03,
            -5.9625492e-03,
            -5.9327547e-03,
            -5.9012242e-03,
            -5.8689752e-03,
            -5.8357291e-03,
            -5.8017840e-03,
            -5.7660135e-03,
            -5.7292580e-03,
            -5.6921359e-03,
            -5.6531863e-03,
            -5.6133708e-03,
            -5.5728880e-03,
            -5.5310648e-03,
            -5.4886879e-03,
            -5.4449981e-03,
            -5.4008522e-03,
            -5.3554157e-03,
            -5.3095165e-03,
            -5.2623347e-03,
            -5.2146885e-03,
            -5.1657665e-03,
            -5.1165141e-03,
            -5.0661198e-03,
            -5.0159063e-03,
            -4.9621851e-03,
            -4.9131637e-03,
            -4.8587202e-03,
            -4.8045541e-03,
            -4.7503950e-03,
            -4.6967891e-03,
            -4.6414946e-03,
            -4.5858088e-03,
            -4.5288779e-03,
            -4.4721534e-03,
            -4.4146502e-03,
            -4.3575375e-03,
            -4.2995515e-03,
            -4.2418239e-03,
            -4.1830810e-03,
            -4.1244864e-03,
            -4.0648571e-03,
            -4.0053697e-03,
            -3.9454176e-03,
            -3.8860202e-03,
            -3.8256031e-03,
            -3.7657025e-03,
            -3.7054255e-03,
            -3.6456370e-03,
            -3.5845127e-03,
            -3.5248263e-03,
            -3.4636027e-03,
            -3.4037197e-03,
            -3.3423669e-03,
            -3.2826243e-03,
            -3.2213633e-03,
            -3.1620227e-03,
            -3.1008681e-03,
            -3.0420922e-03,
            -2.9808737e-03,
            -2.9229264e-03,
            -2.8613499e-03,
            -2.8053242e-03,
            -2.7402675e-03,
            -2.6876762e-03,
            -2.6318671e-03,
            -2.5638986e-03,
            -2.5089139e-03,
            -2.4518545e-03,
            -2.3982054e-03,
            -2.3410494e-03,
            -2.2856394e-03,
            -2.2281725e-03,
            -2.1728019e-03,
            -2.1166756e-03,
            -2.0628240e-03,
            -2.0086666e-03,
            -1.9565053e-03,
            -1.9039197e-03,
            -1.8528413e-03,
            -1.8010978e-03,
            -1.7506988e-03,
            -1.7001005e-03,
            -1.6502441e-03,
            -1.6002816e-03,
            -1.5516253e-03,
            -1.5031361e-03,
            -1.4554163e-03,
            -1.4084261e-03,
            -1.3625714e-03,
            -1.3170280e-03,
            -1.2727172e-03,
            -1.2287387e-03,
            -1.1860089e-03,
            -1.1435771e-03,
            -1.1023162e-03,
            -1.0613312e-03,
            -1.0214818e-03,
            -9.8191779e-04,
            -9.4359410e-04,
            -9.0545263e-04,
            -8.6844401e-04,
            -8.3174520e-04,
            -9.3625753e-03
    };

    static public Map<String, double[]> getFiltersCollection(){
        Map<String, double[]> coeffsMap = new HashMap<String, double[]>();

        //lowPass filters
        coeffsMap.put("Lowpass_128fs",LOWPASS_11Hz_128fs);
        coeffsMap.put("Lowpass_250fs",LOWPASS_11Hz_250fs);
        coeffsMap.put("Lowpass_500fs",LOWPASS_11Hz_500fs);
        coeffsMap.put("Lowpass_1000fs",LOWPASS_11Hz_1000fs);

        //highPass filters
        coeffsMap.put("Highpass_128fs",HIGHPASS_6Hz_128fs);
        coeffsMap.put("Highpass_250fs",HIGHPASS_6Hz_250fs);
        coeffsMap.put("Highpass_500fs",HIGHPASS_6Hz_500fs);
        coeffsMap.put("Highpass_1000fs",HIGHPASS_6Hz_1000fs);

        return coeffsMap;
    }

}
