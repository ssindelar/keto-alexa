package de.sindelar.skill;

import javax.inject.Named;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import de.sindelar.skill.requesthandlers.CustomLaunchRequestHandler;
import de.sindelar.skill.requesthandlers.KVCalcRequestHandler;
import de.sindelar.skill.requesthandlers.WelcomeRequestHandler;


@Named("skill")
public class SkillLambda extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandler(new CustomLaunchRequestHandler())
				.addRequestHandler(new WelcomeRequestHandler())
				.addRequestHandler(new KVCalcRequestHandler())
				.withSkillId("")
				.build();
	}

	public SkillLambda() {
		super(getSkill());
	}
}
