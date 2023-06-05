package command.pattern;

public class SmsCommand implements Command {

    Sms sms;

    public SmsCommand(Sms sms){
        this.sms = sms;
    }

    @Override
    public void execute() {
        sms.sendSms();

    }
}