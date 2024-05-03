package lecture15;

public interface ISkilled {
	void addSkill(ISkill<UserInput> skill, String skillTrigger);
	void callSkills(String skillTrigger, UserInput t);
}
