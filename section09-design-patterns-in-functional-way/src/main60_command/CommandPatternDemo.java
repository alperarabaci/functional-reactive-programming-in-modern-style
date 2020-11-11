package main60_command;

public class CommandPatternDemo {

	public static void main(String[] args) {
		AC ac1 = new AC();
		
		ACAutomationRemote remote = new ACAutomationRemote();
		remote.setCommand(() -> ac1.turnOn());
		remote.buttonPressed();
		
		ACAutomationRemote remote2 = new ACAutomationRemote();
		remote2.setCommand(() -> ac1.turnOff());
		remote2.buttonPressed();
	}

}
