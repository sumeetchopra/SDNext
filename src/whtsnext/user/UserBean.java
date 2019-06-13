package whtsnext.user;

import java.util.List;
import java.util.Map;

public class UserBean {

    private final UserAttributes userAttributes;

    private final String name;

    public UserBean(String name) {
        this.userAttributes = new UserAttributes();
        this.name = name;
    }

    public UserAttributes getUserAttributes() {
        return userAttributes;
    }
    public class UserAttributes {

        private List<Map<String,String>> vehicles;

        private Map<String,String> home;

        private List<Map<String,String>> fines;

        private Map<String, String> license;

        public List<Map<String, String>> getVehicles() {
            return vehicles;
        }

        public UserAttributes setVehicles(List<Map<String, String>> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public Map<String, String> getHome() {
            return home;
        }

        public UserAttributes setHome(Map<String, String> home) {
            this.home = home;
            return this;
        }

        public List<Map<String, String>> getFines() {
            return fines;
        }

        public UserAttributes setFines(List<Map<String, String>> fines) {
            this.fines = fines;
            return this;
        }

        public Map<String, String> getLicense() {
            return license;
        }

        public UserAttributes setLicense(Map<String, String> license) {
            this.license = license;
            return this;
        }


    }
}
