package lecture15;

public class HomeAssistantTester {
	static void printInput(UserInput ui) {
		System.out.println(ui.theInput);
	}

	public static void main(String[] args) {
//		ISkill<UserInput> greeter = t -> System.out.println(t.theInput);
		ISkill<UserInput> greeter = HomeAssistantTester::printInput;
		HomeAssistant assistant = new HomeAssistant();
		assistant.addSkill(greeter, "greet");
		assistant.callSkills("greet", new UserInput());

	}

}
