package lecture15;

public class HomeAssistantTester {

	public static void main(String[] args) {
		ISkill<UserInput> greeter = t -> System.out.println(t.theInput);
		HomeAssistant assistant = new HomeAssistant();
		assistant.addSkill(greeter, "greet");
		assistant.callSkills("greet", new UserInput());

	}

}
