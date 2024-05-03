package lecture15;

import java.util.HashMap;
import java.util.Map;

public class HomeAssistant implements ISkilled {

	
	private Map<String, ISkill> skills;
	public HomeAssistant() {
		this.skills = new HashMap<>();
	}
	@Override
	public void addSkill(ISkill<UserInput> skill, String skillTrigger) {
		// TODO Auto-generated method stub
		this.skills.put(skillTrigger, skill);
	}


	@Override
	public void callSkills(String skillTrigger, UserInput t) {
		this.skills.get(skillTrigger).accept(t);
		
	}

}
