import model.CountryDataObject;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.BotInitializer;
import service.CountryDataObjectService;

public class App {

    private static BotInitializer botInitializer = new BotInitializer();

    public static void main(String[] args) throws TelegramApiException {
        //testing
        CountryDataObjectService countryDataObjectService = new CountryDataObjectService();
        CountryDataObject germany = countryDataObjectService.getCountryDataObject("Germany");
        System.out.println(germany);
    }
}
