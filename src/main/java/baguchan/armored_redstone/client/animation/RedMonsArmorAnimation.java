package baguchan.armored_redstone.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class RedMonsArmorAnimation {
	public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.52f).addAnimation("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-107.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.52f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-107.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.52f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition SHOT = AnimationDefinition.Builder.withLength(1.24f).addAnimation("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.52f, KeyframeAnimations.degreeVec(-85.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.36f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.52f, KeyframeAnimations.degreeVec(-85.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.6f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
}