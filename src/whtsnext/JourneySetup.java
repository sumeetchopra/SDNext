package whtsnext;

import whtsnext.actions.*;

import java.util.ArrayList;
import java.util.List;

public class JourneySetup {

    private static JourneySetup setup = new JourneySetup();

    private List<Journey> journeys = new ArrayList<>();

    private JourneySetup() {
        loadJourneys();
    }

    private void loadJourneys() {
        Journey driveACar = new Journey(1, "Drive A Car");
        JourneyActions getLicense = new GetLicenseJourneyAction(driveACar);
        JourneyActions renewLicense = new RenewLicenseJourneyAction(driveACar);
        JourneyActions buyCar = new BuyCarJourneyAction(driveACar);
        JourneyActions rentCar = new RentCarJourneyAction(driveACar);
        JourneyActions payFines = new PayFinesJourneyAction(driveACar);

        Journey home = new Journey(2, "Home");
        JourneyActions buyHome = new BuyHomeJourneyAction(home);
        JourneyActions rentHome = new RentHomeJourneyAction(home);
        JourneyActions getDewa = new GetDewaJourneyAction(home);
        JourneyActions getCarParking = new GetCarParkingJourneyAction(home);

        Journey insurance = new Journey(3, "Insurance");
        JourneyActions buyHomeInsurance = new BuyHomeInsuranceJourneyAction(insurance);
        JourneyActions renewHomeInsurance = new RenewHomeInsuranceJourneyAction(insurance);
        JourneyActions buyVehicleInsurance = new BuyVehicleInsuranceJourneyAction(insurance);
        JourneyActions renewVehicleInsurance = new RenewVehicleInsuranceJourneyAction(insurance);

        getLicense.getNext().add(renewLicense);
        getLicense.getNext().add(buyCar);
        getLicense.getNext().add(rentCar);
        getLicense.getNext().add(payFines);

        renewLicense.getNext().add(buyCar);
        renewLicense.getNext().add(rentCar);
        renewLicense.getNext().add(payFines);

        buyCar.getNext().add(getCarParking);
        buyCar.getNext().add(buyVehicleInsurance);
        buyCar.getNext().add(payFines);

        rentCar.getNext().add(getCarParking);
        rentCar.getNext().add(buyVehicleInsurance);
        rentCar.getNext().add(payFines);

        buyHome.getNext().add(getDewa);
        buyHome.getNext().add(getCarParking);
        buyHome.getNext().add(buyHomeInsurance);

        rentHome.getNext().add(getDewa);
        rentHome.getNext().add(getCarParking);

        journeys.add(driveACar);
        journeys.add(home);
        journeys.add(insurance);

    }

    public static JourneySetup getInstance() {
        return setup;
    }

    public List<Journey> getJourneys() {
        return this.journeys;
    }

    public void displayList() {
        journeys.forEach((journey) -> {
            System.out.println(journey.getName());
            journey.getActions().forEach((s) -> {
                System.out.println("------------ " + s.getAction());
                s.getNext().forEach((n) -> {
                    System.out.println("==================== " + n.getAction());
                });
            });
        });
    }
}
