import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Sammetestebot extends TelegramLongPollingBot {


    public String getBotUsername() {
        return "";
    }

    public String getBotToken() {
        return "";
    }

    public void onUpdateReceived(Update update) {

//        System.out.println(update.getMessage().getFrom().getFirstName()+" " + update.getMessage().getText());

        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        switch (command) {
            case "/myname":
                System.out.println(update.getMessage().getFrom().getFirstName());

                message.setText(update.getMessage().getFrom().getFirstName());
                break;
            case "/mylastname":
                System.out.println(update.getMessage().getFrom().getLastName());

                message.setText(update.getMessage().getFrom().getLastName());
                break;

            case "/myfullname":
                System.out.println(update.getMessage().getFrom().getFirstName() + " " +
                        update.getMessage().getFrom().getLastName());

                message.setText(update.getMessage().getFrom().getFirstName() + " " +
                        update.getMessage().getFrom().getLastName()+"");
                break;

        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));


        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
