package fr.thoridan.planes.entity.client.models.rafale;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.thoridan.planes.entity.custom.models.rafale.NormalRafale;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;


public class RafaleModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "rafale"), "main");
	private final ModelPart F15;
	private final ModelPart TurboOn;
	private final ModelPart Roues;
	public RafaleModel(ModelPart root) {
		this.F15 = root.getChild("F15");
		this.TurboOn = this.F15.getChild("Body").getChild("TurboOn");
		this.Roues = this.F15.getChild("Roues");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition F15 = partdefinition.addOrReplaceChild("F15", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 2.0F));

		PartDefinition Body = F15.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, -10.0F, 23.0F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).mirror().addBox(-4.0F, -10.0F, 23.0F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, -9.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 40).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.6F, 30.6F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Reacteur = Body.addOrReplaceChild("Reacteur", CubeListBuilder.create(), PartPose.offset(-3.6F, -1.5F, 52.0F));

		PartDefinition cube_r2 = Reacteur.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 137).mirror().addBox(-5.0F, 0.0F, -8.0F, 6.0F, 4.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0432F, 0.0432F, 0.7863F));

		PartDefinition cube_r3 = Reacteur.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(114, 19).mirror().addBox(-11.0F, 2.0F, -8.0F, 5.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.6F, -8.5F, 0.0F, 0.0F, 0.0611F, 0.0F));

		PartDefinition cube_r4 = Reacteur.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 40).mirror().addBox(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, -4.1F, -21.4F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Reacteur.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-5.0F, 0.0F, -15.0F, 6.0F, 4.0F, 44.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(58, 46).mirror().addBox(-5.0F, -10.0F, -13.0F, 7.0F, 4.0F, 42.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6F, -0.5F, 0.0F, 0.0F, 0.0611F, 0.0F));

		PartDefinition cube_r6 = Reacteur.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, 0.0F, -15.0F, 6.0F, 4.0F, 44.0F, new CubeDeformation(0.0F))
				.texOffs(58, 46).addBox(-2.0F, -10.0F, -13.0F, 7.0F, 4.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, -0.5F, 0.0F, 0.0F, -0.0611F, 0.0F));

		PartDefinition cube_r7 = Reacteur.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(86, 137).addBox(-1.0F, 0.0F, -8.0F, 6.0F, 4.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2F, 0.0F, 0.0F, 0.0432F, -0.0432F, -0.7863F));

		PartDefinition cube_r8 = Reacteur.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(94, 92).addBox(-1.0F, -4.0F, -12.0F, 6.0F, 4.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2F, -6.9F, 0.0F, -0.0432F, -0.0432F, 0.7863F));

		PartDefinition cube_r9 = Reacteur.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(94, 92).mirror().addBox(-5.0F, -4.0F, -12.0F, 6.0F, 4.0F, 41.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.9F, 0.0F, -0.0432F, 0.0432F, -0.7863F));

		PartDefinition cube_r10 = Reacteur.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(115, 19).addBox(6.0F, 2.0F, -8.0F, 5.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -8.5F, 0.0F, 0.0F, -0.0611F, 0.0F));

		PartDefinition TurboOn = Body.addOrReplaceChild("TurboOn", CubeListBuilder.create().texOffs(-1, 163).addBox(-4.0F, -8.0F, 77.4F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TurboOff = Body.addOrReplaceChild("TurboOff", CubeListBuilder.create().texOffs(0, 88).addBox(0.0F, -8.0F, 39.0F, 6.0F, 7.0F, 41.0F, new CubeDeformation(0.0F))
				.texOffs(0, 88).mirror().addBox(-6.0F, -8.0F, 39.0F, 6.0F, 7.0F, 41.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Aero = F15.addOrReplaceChild("Aero", CubeListBuilder.create(), PartPose.offset(7.0F, 3.0F, 26.0F));

		PartDefinition Aileron = Aero.addOrReplaceChild("Aileron", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.75F, -12.2057F, 39.3622F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r11 = Aileron.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(59, 68).addBox(-6.5F, -0.5F, -7.5F, 10.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(114, 69).addBox(-6.5F, -0.5F, -3.5F, 22.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.3057F, 3.6378F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = Aileron.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(108, 62).addBox(-9.5F, -0.5F, -3.5F, 26.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.6057F, -5.9622F, 0.0F, -0.5672F, -1.5708F));

		PartDefinition Ailes = Aero.addOrReplaceChild("Ailes", CubeListBuilder.create().texOffs(-2, 19).addBox(-1.0F, -4.0F, 20.7F, 42.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(41, 59).addBox(41.0F, -3.6F, 10.7F, 2.0F, 3.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(41, 59).mirror().addBox(-57.0F, -3.6F, 10.7F, 2.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 19).mirror().addBox(-55.0F, -4.0F, 20.7F, 41.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = Ailes.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(5, 5).mirror().addBox(-54.0F, -4.0F, -8.0F, 58.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.75F, 1.0F, -4.5F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r14 = Ailes.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(147, 100).mirror().addBox(-29.0F, -4.0F, -13.0F, 26.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.75F, 0.5F, 15.9F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r15 = Ailes.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(147, 100).addBox(3.0F, -4.0F, -13.0F, 26.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 0.5F, 15.9F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r16 = Ailes.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(5, 5).addBox(-4.0F, -4.0F, -8.0F, 58.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 1.0F, -4.5F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Canard = Aero.addOrReplaceChild("Canard", CubeListBuilder.create(), PartPose.offset(-11.25F, 1.0F, -22.5F));

		PartDefinition cube_r17 = Canard.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(56, 73).addBox(7.0F, -4.0F, -3.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(84, 40).addBox(8.0F, -4.0F, -2.0F, 15.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(56, 79).addBox(9.0F, -4.0F, 0.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 43).addBox(8.0F, -4.0F, -1.0F, 15.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(56, 60).addBox(6.0F, -4.0F, -7.0F, 17.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(56, 76).addBox(7.0F, -4.0F, -4.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r18 = Canard.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 73).mirror().addBox(-23.0F, -4.0F, -3.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(84, 40).mirror().addBox(-23.0F, -4.0F, -2.0F, 15.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 79).mirror().addBox(-23.0F, -4.0F, 0.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(84, 43).mirror().addBox(-23.0F, -4.0F, -1.0F, 15.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 60).mirror().addBox(-23.0F, -4.0F, -7.0F, 17.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 76).mirror().addBox(-23.0F, -4.0F, -4.0F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.5F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition Intake = Aero.addOrReplaceChild("Intake", CubeListBuilder.create().texOffs(147, 62).mirror().addBox(-17.0F, -2.0F, -22.4F, 6.0F, 6.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(147, 62).addBox(-3.0F, -2.0F, -22.4F, 6.0F, 6.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Nez = F15.addOrReplaceChild("Nez", CubeListBuilder.create().texOffs(0, 88).mirror().addBox(-5.0F, -4.7F, 1.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(24, 40).mirror().addBox(-5.0F, -9.7F, 8.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 9).mirror().addBox(-5.0F, -9.7F, 5.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 88).addBox(-1.0F, -4.7F, 1.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(24, 40).addBox(-1.0F, -9.7F, 8.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(-1.0F, -9.7F, 5.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.7F, -23.0F));

		PartDefinition cube_r19 = Nez.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(49, 92).addBox(-5.0F, -5.0F, -5.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r20 = Nez.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(17, 68).addBox(-2.0F, -5.0F, -8.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(17, 68).mirror().addBox(-5.6F, -5.0F, -8.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.8F, -4.6F, 6.0F, 0.3752F, 0.0F, 0.0F));

		PartDefinition cube_r21 = Nez.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(137, 143).addBox(-1.0F, -4.0F, -24.0F, 3.0F, 4.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(138, 143).mirror().addBox(-4.0F, -4.0F, -24.0F, 3.0F, 4.0F, 35.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.3F, 26.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Cockpit = F15.addOrReplaceChild("Cockpit", CubeListBuilder.create(), PartPose.offset(3.5F, -4.0F, -9.5F));

		PartDefinition Vitre = Cockpit.addOrReplaceChild("Vitre", CubeListBuilder.create().texOffs(57, 93).mirror().addBox(-7.1F, -1.65F, -17.5F, 0.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(74, 109).mirror().addBox(-7.1F, -0.65F, -19.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(74, 110).mirror().addBox(-7.1F, 0.35F, -21.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(76, 108).mirror().addBox(-7.1F, -0.65F, -4.5F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(79, 107).mirror().addBox(-7.1F, -0.15F, -2.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(66, 119).mirror().addBox(-7.1F, 0.35F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(57, 93).addBox(0.1F, -1.65F, -17.5F, 0.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(74, 109).addBox(0.1F, -0.65F, -19.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(74, 110).addBox(0.1F, 0.35F, -21.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(76, 108).addBox(0.1F, -0.65F, -4.5F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 107).addBox(0.1F, -0.15F, -2.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(78, 110).addBox(0.1F, 0.35F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.35F, 21.0F));

		PartDefinition cube_r22 = Vitre.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(53, 109).addBox(-6.5F, -7.0F, -0.5F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r23 = Vitre.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(71, 114).addBox(-6.5F, -6.0F, 0.5F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.15F, -21.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r24 = Vitre.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(71, 114).addBox(-6.5F, -7.0F, 0.5F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, -14.1F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Structure = Cockpit.addOrReplaceChild("Structure", CubeListBuilder.create().texOffs(163, 0).mirror().addBox(-5.0F, -10.0F, -13.0F, 1.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 136).mirror().addBox(-5.0F, -4.0F, -13.0F, 4.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(163, 0).addBox(2.0F, -10.0F, -13.0F, 1.0F, 6.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(49, 136).addBox(-1.0F, -4.0F, -13.0F, 4.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 11.0F, 12.5F));

		PartDefinition ArmatureVitre = Cockpit.addOrReplaceChild("ArmatureVitre", CubeListBuilder.create(), PartPose.offset(0.5F, -2.4F, 14.4F));

		PartDefinition cube_r25 = ArmatureVitre.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition cube_r26 = ArmatureVitre.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(11, 19).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition cube_r27 = ArmatureVitre.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(40, 55).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 55).mirror().addBox(-7.3F, -8.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 0.0F, -7.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r28 = ArmatureVitre.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(12, 40).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 40).mirror().addBox(-7.3F, -7.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 2.55F, 6.5F, 1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r29 = ArmatureVitre.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(40, 66).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 66).mirror().addBox(-7.3F, -6.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 2.9F, -14.4F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r30 = ArmatureVitre.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r31 = ArmatureVitre.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(11, 19).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 0.0F, -9.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition Interieur = Cockpit.addOrReplaceChild("Interieur", CubeListBuilder.create(), PartPose.offset(0.5F, -2.4F, 14.4F));

		PartDefinition TableaudeBord = Interieur.addOrReplaceChild("TableaudeBord", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -5.0F, -6.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 19).addBox(-1.0F, -5.0F, -6.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 10.4F, -8.9F));

		PartDefinition cube_r32 = TableaudeBord.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).mirror().addBox(-4.0F, -2.0F, -2.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.15F, -4.1F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Chaise = Interieur.addOrReplaceChild("Chaise", CubeListBuilder.create().texOffs(0, 75).mirror().addBox(-4.0F, -0.4F, -5.2F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 28).mirror().addBox(-3.0F, 0.6F, -4.2F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 75).addBox(-1.0F, -0.4F, -5.2F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-1.0F, 0.6F, -4.2F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 7.8F, -3.7F));

		PartDefinition cube_r33 = Chaise.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(87, 92).addBox(-1.0F, -2.0F, -7.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(87, 92).mirror().addBox(-4.0F, -2.0F, -7.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.9199F, 0.0F, 0.0F));

		PartDefinition Roues = F15.addOrReplaceChild("Roues", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-18.0F, 6.0F, 15.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 48).addBox(2.0F, 6.0F, 15.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(-8.0F, 6.0F, -39.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 3.0F, 30.6F));

		PartDefinition cube_r34 = Roues.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(62, 40).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 6.0F, -34.6F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r35 = Roues.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 71).addBox(-2.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 17.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r36 = Roues.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-3.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 7.0F, 17.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.onGround()) {
			this.TurboOn.visible = false;
			this.Roues.visible = true;
		} else {
			this.TurboOn.visible = true;
			this.Roues.visible = false;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		F15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}