import whtsnext.WhtsNextDeterminationEngine;
import whtsnext.user.UserBean;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        WhtsNextDeterminationEngine engine = new WhtsNextDeterminationEngine();

        final UserBean userBean = new UserBean("SC");
        userBean.getUserAttributes().setHome(getOwnedHomeWithDewa());
        userBean.getUserAttributes().setLicense(getExpiredLicense());
        engine.whtsNextForUser(userBean);
    }

    private static Map<String, String> getOwnedHome() {
        Map<String, String> mp = new HashMap<>();
        mp.put("home", "A");
        mp.put("owned", "Y");
        return mp;
    }

    private static Map<String, String> getOwnedHomeWithInsurance() {
        Map<String, String> mp = getOwnedHome();
        mp.put("insurance", "Y");
        return mp;

    }

    private static Map<String, String> getOwnedHomeWithExpiredInsurance() {
        Map<String, String> mp = getOwnedHomeWithInsurance();
        mp.put("insurancexpired", "Y");
        return mp;
    }

    private static Map<String, String> getOwnedHomeWithDewa() {
        Map<String, String> mp = getOwnedHome();
        mp.put("dewa", "Y");
        return mp;
    }

    private static Map<String, String> getLicense() {
        Map<String, String> mp = new HashMap<>();
        mp.put("license", "A");
        return mp;
    }

    private static Map<String, String> getExpiredLicense() {
        Map<String, String> mp = getLicense();
        mp.put("expired", "Y");
        return mp;
    }
}
