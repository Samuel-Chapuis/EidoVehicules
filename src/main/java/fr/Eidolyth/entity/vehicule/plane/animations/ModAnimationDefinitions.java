package fr.Eidolyth.entity.vehicule.plane.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {
			public static final AnimationDefinition PALE_ANIMATION = AnimationDefinition.Builder.withLength(0.25f).looping()
			.addAnimation("Pales",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 123f), AnimationChannel.Interpolations.LINEAR)))
						.build();

		public static final AnimationDefinition ANIMATION = AnimationDefinition.Builder.withLength(0.25f)
				.addAnimation("TurboOn",
						new AnimationChannel(AnimationChannel.Targets.POSITION,
								new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0.5f),
										AnimationChannel.Interpolations.LINEAR),
								new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0.7f),
										AnimationChannel.Interpolations.LINEAR))).build();
}
