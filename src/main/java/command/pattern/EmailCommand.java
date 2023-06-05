package command.pattern;

public class EmailCommand implements Command{

    Email email;

    public EmailCommand(Email email){
        this.email = email;
    }

    @Override
    public void execute() {
        email.sendEmail();
    }
}