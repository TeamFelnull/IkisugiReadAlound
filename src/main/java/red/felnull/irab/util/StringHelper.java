package red.felnull.irab.util;

public class StringHelper {
    public static String[] split(int size, String st) {

        int sps = st.length() / size;
        String[] sts = new String[sps + 1];
        for (int i = 0; i < sps; i++) {
            sts[i] = st.substring(size * i, size * i + size);
        }
        sts[sps] = st.substring(size * sps);
        return sts;
    }
}
