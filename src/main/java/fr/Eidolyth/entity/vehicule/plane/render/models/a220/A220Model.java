package fr.Eidolyth.entity.vehicule.plane.render.models.a220;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class A220Model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart main;
	private final ModelPart Middle;
	private final ModelPart Fuselage;
	private final ModelPart Tail3;
	private final ModelPart Noze3;
	private final ModelPart TrailFin;
	private final ModelPart Interior;
	private final ModelPart Right;
	private final ModelPart Chassis2;
	private final ModelPart Noze2;
	private final ModelPart WindShield2;
	private final ModelPart Fill5;
	private final ModelPart SideWindShield2;
	private final ModelPart Fill6;
	private final ModelPart FullTail2;
	private final ModelPart Tail2;
	private final ModelPart Fill7;
	private final ModelPart TailSide2;
	private final ModelPart Fill8;
	private final ModelPart Body2;
	private final ModelPart Interieur2;
	private final ModelPart Lever;
	private final ModelPart Passagers;
	private final ModelPart C1;
	private final ModelPart C2;
	private final ModelPart C4;
	private final ModelPart C5;
	private final ModelPart C6;
	private final ModelPart ChaiseCommand;
	private final ModelPart Aero;
	private final ModelPart Elevator;
	private final ModelPart Winglet;
	private final ModelPart Wing;
	private final ModelPart Reactor;
	private final ModelPart Big;
	private final ModelPart bone2;
	private final ModelPart Small;
	private final ModelPart bone3;
	private final ModelPart Wheels;
	private final ModelPart WingWheelRight;
	private final ModelPart wheel5;
	private final ModelPart wheel4;
	private final ModelPart wheel3;
	private final ModelPart wheel8;
	private final ModelPart WingWheelLeft;
	private final ModelPart wheel9;
	private final ModelPart wheel10;
	private final ModelPart wheel11;
	private final ModelPart wheel15;
	private final ModelPart SmallWheel;
	private final ModelPart wheel2;
	private final ModelPart wheel7;
	private final ModelPart Left;
	private final ModelPart Chassis3;
	private final ModelPart Noze4;
	private final ModelPart WindShield3;
	private final ModelPart Fill2;
	private final ModelPart SideWindShield3;
	private final ModelPart Fill3;
	private final ModelPart FullTail3;
	private final ModelPart Tail4;
	private final ModelPart Fill4;
	private final ModelPart TailSide3;
	private final ModelPart Fill9;
	private final ModelPart Body3;
	private final ModelPart Interieur3;
	private final ModelPart Lever2;
	private final ModelPart Passagers2;
	private final ModelPart C3;
	private final ModelPart C7;
	private final ModelPart C8;
	private final ModelPart C9;
	private final ModelPart C10;
	private final ModelPart ChaiseCommand2;
	private final ModelPart Aero2;
	private final ModelPart Elevator2;
	private final ModelPart Winglet2;
	private final ModelPart Wing2;
	private final ModelPart Reactor2;
	private final ModelPart Big2;
	private final ModelPart bone4;
	private final ModelPart Small2;
	private final ModelPart bone5;

	public A220Model(ModelPart root) {
		this.main = root.getChild("main");
		this.Middle = this.main.getChild("Middle");
		this.Fuselage = this.Middle.getChild("Fuselage");
		this.Tail3 = this.Middle.getChild("Tail3");
		this.Noze3 = this.Middle.getChild("Noze3");
		this.TrailFin = this.Middle.getChild("TrailFin");
		this.Interior = this.Middle.getChild("Interior");
		this.Right = this.main.getChild("Right");
		this.Chassis2 = this.Right.getChild("Chassis2");
		this.Noze2 = this.Chassis2.getChild("Noze2");
		this.WindShield2 = this.Noze2.getChild("WindShield2");
		this.Fill5 = this.WindShield2.getChild("Fill5");
		this.SideWindShield2 = this.Noze2.getChild("SideWindShield2");
		this.Fill6 = this.SideWindShield2.getChild("Fill6");
		this.FullTail2 = this.Chassis2.getChild("FullTail2");
		this.Tail2 = this.FullTail2.getChild("Tail2");
		this.Fill7 = this.Tail2.getChild("Fill7");
		this.TailSide2 = this.FullTail2.getChild("TailSide2");
		this.Fill8 = this.TailSide2.getChild("Fill8");
		this.Body2 = this.Chassis2.getChild("Body2");
		this.Interieur2 = this.Right.getChild("Interieur2");
		this.Lever = this.Interieur2.getChild("Lever");
		this.Passagers = this.Interieur2.getChild("Passagers");
		this.C1 = this.Passagers.getChild("C1");
		this.C2 = this.Passagers.getChild("C2");
		this.C4 = this.Passagers.getChild("C4");
		this.C5 = this.Passagers.getChild("C5");
		this.C6 = this.Passagers.getChild("C6");
		this.ChaiseCommand = this.Interieur2.getChild("ChaiseCommand");
		this.Aero = this.Right.getChild("Aero");
		this.Elevator = this.Aero.getChild("Elevator");
		this.Winglet = this.Aero.getChild("Winglet");
		this.Wing = this.Aero.getChild("Wing");
		this.Reactor = this.Aero.getChild("Reactor");
		this.Big = this.Reactor.getChild("Big");
		this.bone2 = this.Big.getChild("bone2");
		this.Small = this.Reactor.getChild("Small");
		this.bone3 = this.Small.getChild("bone3");
		this.Wheels = this.main.getChild("Wheels");
		this.WingWheelRight = this.Wheels.getChild("WingWheelRight");
		this.wheel5 = this.WingWheelRight.getChild("wheel5");
		this.wheel4 = this.WingWheelRight.getChild("wheel4");
		this.wheel3 = this.WingWheelRight.getChild("wheel3");
		this.wheel8 = this.WingWheelRight.getChild("wheel8");
		this.WingWheelLeft = this.Wheels.getChild("WingWheelLeft");
		this.wheel9 = this.WingWheelLeft.getChild("wheel9");
		this.wheel10 = this.WingWheelLeft.getChild("wheel10");
		this.wheel11 = this.WingWheelLeft.getChild("wheel11");
		this.wheel15 = this.WingWheelLeft.getChild("wheel15");
		this.SmallWheel = this.Wheels.getChild("SmallWheel");
		this.wheel2 = this.SmallWheel.getChild("wheel2");
		this.wheel7 = this.SmallWheel.getChild("wheel7");
		this.Left = this.main.getChild("Left");
		this.Chassis3 = this.Left.getChild("Chassis3");
		this.Noze4 = this.Chassis3.getChild("Noze4");
		this.WindShield3 = this.Noze4.getChild("WindShield3");
		this.Fill2 = this.WindShield3.getChild("Fill2");
		this.SideWindShield3 = this.Noze4.getChild("SideWindShield3");
		this.Fill3 = this.SideWindShield3.getChild("Fill3");
		this.FullTail3 = this.Chassis3.getChild("FullTail3");
		this.Tail4 = this.FullTail3.getChild("Tail4");
		this.Fill4 = this.Tail4.getChild("Fill4");
		this.TailSide3 = this.FullTail3.getChild("TailSide3");
		this.Fill9 = this.TailSide3.getChild("Fill9");
		this.Body3 = this.Chassis3.getChild("Body3");
		this.Interieur3 = this.Left.getChild("Interieur3");
		this.Lever2 = this.Interieur3.getChild("Lever2");
		this.Passagers2 = this.Interieur3.getChild("Passagers2");
		this.C3 = this.Passagers2.getChild("C3");
		this.C7 = this.Passagers2.getChild("C7");
		this.C8 = this.Passagers2.getChild("C8");
		this.C9 = this.Passagers2.getChild("C9");
		this.C10 = this.Passagers2.getChild("C10");
		this.ChaiseCommand2 = this.Interieur3.getChild("ChaiseCommand2");
		this.Aero2 = this.Left.getChild("Aero2");
		this.Elevator2 = this.Aero2.getChild("Elevator2");
		this.Winglet2 = this.Aero2.getChild("Winglet2");
		this.Wing2 = this.Aero2.getChild("Wing2");
		this.Reactor2 = this.Aero2.getChild("Reactor2");
		this.Big2 = this.Reactor2.getChild("Big2");
		this.bone4 = this.Big2.getChild("bone4");
		this.Small2 = this.Reactor2.getChild("Small2");
		this.bone5 = this.Small2.getChild("bone5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 4.0F));

		PartDefinition Middle = main.addOrReplaceChild("Middle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Fuselage = Middle.addOrReplaceChild("Fuselage", CubeListBuilder.create().texOffs(0, 196).addBox(-11.0F, -30.0F, 1.0F, 18.0F, 1.0F, 195.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-11.0F, 1.0F, 1.0F, 18.0F, 1.0F, 195.0F, new CubeDeformation(0.0F))
				.texOffs(784, 663).addBox(-12.0F, 1.0F, 76.0F, 20.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -11.0F));

		PartDefinition Tail3 = Middle.addOrReplaceChild("Tail3", CubeListBuilder.create(), PartPose.offset(2.0F, 1.8F, 185.1F));

		PartDefinition cube_r1 = Tail3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(826, 123).addBox(-11.0F, -7.0F, -0.5F, 18.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4137F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Tail3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(342, 806).addBox(-11.0F, -22.0F, -0.5F, 18.0F, 31.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.8F, 14.1F, -1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Tail3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(826, 103).addBox(-5.5F, -5.0F, -0.5F, 18.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -22.0F, 32.2F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Tail3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(784, 629).addBox(-11.0F, 0.0F, -1.0F, 18.0F, 1.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.2F, 0.9F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Noze3 = Middle.addOrReplaceChild("Noze3", CubeListBuilder.create().texOffs(686, 386).addBox(-11.0F, 18.6F, -30.1F, 18.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -28.8F, -10.1F));

		PartDefinition cube_r5 = Noze3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(826, 114).addBox(-11.0F, -1.0F, -0.5F, 18.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4137F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Noze3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(826, 0).addBox(-11.0F, -9.0F, -0.5F, 18.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3F, -13.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Noze3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(826, 60).addBox(-11.0F, -9.0F, -0.5F, 18.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, -25.5F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r8 = Noze3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(826, 75).addBox(-11.0F, -6.0F, -0.5F, 18.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 25.2F, -24.6F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Noze3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(792, 487).addBox(-11.0F, -1.0F, -18.0F, 18.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 31.2F, -0.9F, -0.1309F, 0.0F, 0.0F));

		PartDefinition TrailFin = Middle.addOrReplaceChild("TrailFin", CubeListBuilder.create().texOffs(826, 17).addBox(14.825F, -0.55F, 7.7484F, 6.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.725F, -51.15F, 202.2516F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r10 = TrailFin.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(784, 696).addBox(-5.0F, -0.5F, -13.5F, 22.0F, 1.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.8116F, 0.05F, -8.3511F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r11 = TrailFin.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(784, 722).addBox(16.5F, -0.5F, -10.5F, 34.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.675F, 0.05F, -2.5516F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r12 = TrailFin.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(772, 350).addBox(4.5F, -11.5F, -0.5F, 57.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.175F, 10.55F, -31.4516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition Interior = Middle.addOrReplaceChild("Interior", CubeListBuilder.create().texOffs(221, 849).addBox(-8.0F, -28.5F, 16.0F, 16.0F, 30.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(221, 849).addBox(-8.0F, -28.5F, 162.0F, 16.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = Interior.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(211, 914).addBox(-9.0F, -4.0F, -1.5F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -13.4254F, -25.4009F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r14 = Interior.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(207, 890).addBox(-11.0F, -13.0F, -18.0F, 17.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.4F, -11.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Right = main.addOrReplaceChild("Right", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 191.0F));

		PartDefinition Chassis2 = Right.addOrReplaceChild("Chassis2", CubeListBuilder.create(), PartPose.offset(21.0F, 0.0F, -215.0F));

		PartDefinition Noze2 = Chassis2.addOrReplaceChild("Noze2", CubeListBuilder.create(), PartPose.offset(-22.0F, 0.0F, 22.0F));

		PartDefinition WindShield2 = Noze2.addOrReplaceChild("WindShield2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Fill5 = WindShield2.addOrReplaceChild("Fill5", CubeListBuilder.create().texOffs(284, 841).addBox(10.0F, -10.6F, -29.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(280, 841).addBox(10.0F, -11.0F, -28.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(830, 365).addBox(10.0F, -11.6F, -27.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(186, 841).addBox(10.0F, -12.2F, -26.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(174, 841).addBox(10.0F, -12.6F, -25.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(802, 840).addBox(10.0F, -13.7F, -24.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(786, 840).addBox(10.0F, -14.3F, -23.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(452, 840).addBox(10.0F, -14.7F, -22.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(436, 840).addBox(10.0F, -15.4F, -21.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(418, 840).addBox(10.0F, -15.8F, -20.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(396, 840).addBox(10.0F, -16.4F, -19.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(380, 840).addBox(10.0F, -16.9F, -18.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(628, 838).addBox(10.0F, -17.4F, -17.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(620, 838).addBox(10.0F, -18.4F, -16.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(358, 838).addBox(10.0F, -19.4F, -15.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(826, 836).addBox(10.0F, -20.4F, -14.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(774, 836).addBox(10.0F, -21.4F, -13.0F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(682, 836).addBox(10.0F, -22.7F, -12.0F, 1.0F, 23.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(674, 836).addBox(10.0F, -23.7F, -11.0F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(662, 836).addBox(10.0F, -24.5F, -10.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(654, 836).addBox(10.0F, -25.5F, -9.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(646, 836).addBox(10.0F, -26.5F, -8.0F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(516, 835).addBox(10.0F, -27.5F, -7.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(460, 835).addBox(10.0F, -28.0F, -6.0F, 1.0F, 29.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(762, 836).addBox(10.0F, -29.0F, -4.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(830, 836).addBox(10.0F, -7.0F, -4.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.5F, 0.0F));

		PartDefinition cube_r15 = Fill5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(602, 838).addBox(0.5F, -2.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, -10.1F, -4.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r16 = Fill5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(134, 840).addBox(0.5F, -3.5F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(124, 840).addBox(0.0F, -3.5F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -23.4F, 0.9F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r17 = Fill5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(592, 838).addBox(0.5F, -5.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(370, 838).addBox(0.0F, -5.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -17.9F, -4.6F, -0.7854F, 0.0F, 0.0F));

		PartDefinition SideWindShield2 = Noze2.addOrReplaceChild("SideWindShield2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition cube_r18 = SideWindShield2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(380, 824).addBox(-5.0F, 0.0F, -13.0F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -5.7F, 0.8F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r19 = SideWindShield2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(826, 178).addBox(-3.0F, -8.0F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -11.5F, -12.6F, 1.5708F, 0.5672F, 0.0F));

		PartDefinition cube_r20 = SideWindShield2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(738, 818).addBox(-4.0F, -2.0F, -15.0F, 5.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -22.4F, 1.4F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Fill6 = SideWindShield2.addOrReplaceChild("Fill6", CubeListBuilder.create().texOffs(780, 815).addBox(10.0F, -15.0F, -12.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(384, 840).addBox(10.0F, -21.0F, -4.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(428, 840).addBox(10.0F, -20.0F, -5.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(444, 840).addBox(10.0F, -19.0F, -6.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(778, 840).addBox(10.0F, -18.0F, -7.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(794, 840).addBox(10.0F, -18.0F, -8.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(814, 840).addBox(10.0F, -17.0F, -9.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(178, 841).addBox(10.0F, -16.0F, -10.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(820, 581).addBox(10.0F, -15.0F, -11.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(154, 840).addBox(10.0F, -22.0F, -3.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(158, 840).addBox(10.0F, -22.0F, -2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(612, 838).addBox(10.0F, -23.0F, -1.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(346, 838).addBox(10.0F, -24.0F, 0.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.9F, 0.5F, 0.0F));

		PartDefinition FullTail2 = Chassis2.addOrReplaceChild("FullTail2", CubeListBuilder.create(), PartPose.offset(-22.0F, 0.0F, 22.0F));

		PartDefinition Tail2 = FullTail2.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offset(0.0F, -27.0F, 188.0F));

		PartDefinition Fill7 = Tail2.addOrReplaceChild("Fill7", CubeListBuilder.create().texOffs(810, 840).addBox(10.0F, 2.9F, 29.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(806, 840).addBox(10.0F, 2.5F, 30.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(790, 840).addBox(10.0F, 2.6F, 28.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(456, 840).addBox(10.0F, 2.4F, 27.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(440, 840).addBox(10.0F, 1.9F, 26.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(414, 840).addBox(10.0F, 1.7F, 25.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(388, 840).addBox(10.0F, 1.4F, 24.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(410, 840).addBox(10.0F, 1.7F, 23.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(170, 840).addBox(10.0F, 1.3F, 22.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(120, 840).addBox(10.0F, 1.2F, 21.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(632, 838).addBox(10.0F, 1.6F, 20.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(624, 838).addBox(10.0F, 1.2F, 19.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(350, 838).addBox(10.0F, 1.1F, 18.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(838, 132).addBox(10.0F, 0.6F, 17.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(342, 838).addBox(10.0F, 1.2F, 16.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(822, 836).addBox(10.0F, 1.0F, 15.0F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(758, 836).addBox(10.0F, 0.4F, 14.0F, 1.0F, 22.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(738, 836).addBox(10.0F, 0.4F, 13.0F, 1.0F, 23.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(678, 836).addBox(10.0F, 0.0F, 12.0F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(666, 836).addBox(10.0F, -0.3F, 11.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(670, 836).addBox(10.0F, -0.1F, 10.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(658, 836).addBox(10.0F, -0.3F, 9.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(650, 836).addBox(10.0F, -0.5F, 8.0F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(638, 836).addBox(10.0F, -0.7F, 7.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(642, 836).addBox(10.0F, -0.5F, 6.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(466, 835).addBox(10.0F, -1.0F, 4.0F, 1.0F, 29.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(826, 132).addBox(10.0F, -1.0F, -1.0F, 1.0F, 30.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, -0.5F, 0.0F));

		PartDefinition TailSide2 = FullTail2.addOrReplaceChild("TailSide2", CubeListBuilder.create(), PartPose.offset(0.0F, -27.0F, 188.0F));

		PartDefinition cube_r21 = TailSide2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(420, 824).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9F, 5.7F, -0.7F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r22 = TailSide2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(712, 832).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 11.5F, 12.6F, 1.5708F, -0.5672F, 0.0F));

		PartDefinition cube_r23 = TailSide2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(789, 831).addBox(-2.5F, -1.0F, 1.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.4F, 22.232F, -8.0378F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r24 = TailSide2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(780, 822).addBox(-4.0F, 0.0F, -1.0F, 5.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9F, 22.4F, -0.8F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Fill8 = TailSide2.addOrReplaceChild("Fill8", CubeListBuilder.create().texOffs(824, 581).addBox(10.0F, 9.0F, 11.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(392, 840).addBox(10.0F, 6.0F, 3.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(432, 840).addBox(10.0F, 7.0F, 4.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(448, 840).addBox(10.0F, 7.0F, 5.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(782, 840).addBox(10.0F, 7.0F, 6.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(798, 840).addBox(10.0F, 8.0F, 7.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(818, 840).addBox(10.0F, 8.0F, 8.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(182, 841).addBox(10.0F, 9.0F, 9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(828, 581).addBox(10.0F, 9.0F, 10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(162, 840).addBox(10.0F, 6.0F, 2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(166, 840).addBox(10.0F, 6.0F, 1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(616, 838).addBox(10.0F, 5.0F, 0.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(354, 838).addBox(10.0F, 5.0F, -1.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.8F, -0.5F, 0.0F));

		PartDefinition Body2 = Chassis2.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 606).addBox(10.0F, -29.0F, 1.0F, 1.0F, 5.0F, 195.0F, new CubeDeformation(0.0F))
				.texOffs(392, 588).addBox(10.0F, -5.0F, 1.0F, 1.0F, 6.0F, 195.0F, new CubeDeformation(0.0F))
				.texOffs(392, 392).addBox(11.0F, -25.0F, 1.0F, 5.0F, 1.0F, 195.0F, new CubeDeformation(0.0F))
				.texOffs(314, 549).addBox(15.0F, -24.0F, 158.0F, 1.0F, 19.0F, 38.0F, new CubeDeformation(0.0F))
				.texOffs(200, 483).addBox(15.0F, -24.0F, 31.0F, 1.0F, 19.0F, 127.0F, new CubeDeformation(0.0F))
				.texOffs(165, 557).addBox(15.0F, -24.0F, 1.0F, 1.0F, 19.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(426, 0).addBox(11.0F, -5.0F, 1.0F, 5.0F, 1.0F, 195.0F, new CubeDeformation(0.0F)), PartPose.offset(-22.0F, 0.5F, 13.0F));

		PartDefinition cube_r25 = Body2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(772, 196).addBox(-1.0F, -3.0F, 77.0F, 3.0F, 6.0F, 73.0F, new CubeDeformation(0.0F))
				.texOffs(784, 779).addBox(-1.0F, -10.0F, 48.0F, 6.0F, 14.0F, 29.0F, new CubeDeformation(0.0F))
				.texOffs(772, 275).addBox(-1.0F, -3.0F, -20.0F, 3.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.6F, -3.3F, 29.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r26 = Body2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(392, 789).addBox(-3.0F, -10.5F, -14.5F, 6.0F, 6.0F, 29.0F, new CubeDeformation(0.0F))
				.texOffs(784, 739).addBox(-5.0F, -4.5F, -14.5F, 8.0F, 11.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.4891F, -6.3607F, 91.5F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r27 = Body2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(426, 196).addBox(-1.0F, -3.0F, -20.0F, 3.0F, 6.0F, 170.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.6F, -25.6F, 29.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Interieur2 = Right.addOrReplaceChild("Interieur2", CubeListBuilder.create().texOffs(258, 851).addBox(18.0F, -18.5F, 19.0F, 4.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(258, 851).addBox(18.0F, -18.5F, 165.0F, 4.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -5.0F, -194.0F));

		PartDefinition Lever = Interieur2.addOrReplaceChild("Lever", CubeListBuilder.create(), PartPose.offset(15.5F, -6.2633F, -10.5689F));

		PartDefinition cube_r28 = Lever.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(230, 900).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1231F, 0.0447F, 0.3463F));

		PartDefinition cube_r29 = Lever.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(230, 900).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -0.1231F, -0.0447F, -0.3463F));

		PartDefinition cube_r30 = Lever.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(227, 899).addBox(-1.0F, -13.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(226, 900).addBox(-3.0F, -13.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 13.9633F, 2.5689F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Passagers = Interieur2.addOrReplaceChild("Passagers", CubeListBuilder.create(), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition C1 = Passagers.addOrReplaceChild("C1", CubeListBuilder.create().texOffs(826, 89).addBox(1.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 51.0F));

		PartDefinition Dossier_r1 = C1.addOrReplaceChild("Dossier_r1", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C2 = Passagers.addOrReplaceChild("C2", CubeListBuilder.create().texOffs(826, 89).addBox(1.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 74.0F));

		PartDefinition Dossier_r2 = C2.addOrReplaceChild("Dossier_r2", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C4 = Passagers.addOrReplaceChild("C4", CubeListBuilder.create().texOffs(826, 89).addBox(1.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 143.0F));

		PartDefinition Dossier_r3 = C4.addOrReplaceChild("Dossier_r3", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C5 = Passagers.addOrReplaceChild("C5", CubeListBuilder.create().texOffs(826, 89).addBox(1.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 97.0F));

		PartDefinition Dossier_r4 = C5.addOrReplaceChild("Dossier_r4", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C6 = Passagers.addOrReplaceChild("C6", CubeListBuilder.create().texOffs(826, 89).addBox(1.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 120.0F));

		PartDefinition Dossier_r5 = C6.addOrReplaceChild("Dossier_r5", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition ChaiseCommand = Interieur2.addOrReplaceChild("ChaiseCommand", CubeListBuilder.create().texOffs(826, 89).addBox(10.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(638, 817).addBox(10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition Dossier_r6 = ChaiseCommand.addOrReplaceChild("Dossier_r6", CubeListBuilder.create().texOffs(688, 832).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Aero = Right.addOrReplaceChild("Aero", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, -191.0F));

		PartDefinition Elevator = Aero.addOrReplaceChild("Elevator", CubeListBuilder.create().texOffs(826, 32).addBox(112.9F, -6.7F, 113.8F, 7.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-65.9F, -16.1F, 83.2F));

		PartDefinition cube_r31 = Elevator.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(576, 817).addBox(6.0F, -0.5F, -13.5F, 11.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(68.3634F, -6.0F, 100.7005F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r32 = Elevator.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(462, 789).addBox(16.5F, -0.5F, -10.5F, 34.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(66.5F, -6.0F, 106.5F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r33 = Elevator.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(784, 614).addBox(11.5F, -11.5F, -0.5F, 50.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(70.0F, 4.5F, 77.6F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Winglet = Aero.addOrReplaceChild("Winglet", CubeListBuilder.create().texOffs(380, 806).addBox(1.1F, -14.7F, 24.5F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(400, 840).addBox(1.1F, -9.7F, 20.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(116.4F, -7.8F, 97.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r34 = Winglet.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(422, 840).addBox(-0.15F, -2.15F, -2.75F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -19.95F, 31.95F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r35 = Winglet.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(772, 789).addBox(2.55F, -5.45F, -0.15F, 1.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, -18.85F, 26.85F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Wing = Aero.addOrReplaceChild("Wing", CubeListBuilder.create().texOffs(784, 588).addBox(14.0F, -7.0F, 75.0F, 35.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(688, 818).addBox(14.0F, -7.0F, 63.0F, 13.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(826, 46).addBox(113.0F, -6.7F, 113.8F, 7.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition cube_r36 = Wing.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(686, 372).addBox(-25.5F, -0.5F, -12.5F, 76.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(66.5F, -6.0F, 106.5F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r37 = Wing.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(520, 801).addBox(-61.5F, -12.5F, -0.5F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(426, 372).addBox(-55.5F, -12.5F, -0.5F, 117.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(66.5F, 4.5F, 83.5F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Reactor = Aero.addOrReplaceChild("Reactor", CubeListBuilder.create(), PartPose.offset(-37.0F, 14.0F, 45.0F));

		PartDefinition Big = Reactor.addOrReplaceChild("Big", CubeListBuilder.create().texOffs(626, 789).addBox(-6.0F, -26.5F, -1.8F, 12.0F, 3.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(792, 507).addBox(10.0F, -19.5F, -1.8F, 3.0F, 12.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(552, 789).addBox(-6.0F, -3.3F, -1.8F, 12.0F, 3.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(792, 544).addBox(-13.0F, -19.5F, -1.8F, 3.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(78.0F, 0.0F, 0.0F));

		PartDefinition cube_r38 = Big.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(286, 806).addBox(-2.0F, -5.0F, -20.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1F, -21.5F, 18.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r39 = Big.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(230, 806).addBox(-2.0F, -5.0F, -20.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1F, -5.3F, 18.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r40 = Big.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(174, 806).addBox(-1.5F, -5.0F, -30.5F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4536F, -4.9464F, 28.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r41 = Big.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(520, 817).addBox(-1.5F, -5.0F, -25.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4536F, -21.8536F, 23.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone2 = Big.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(800, 365).addBox(-10.0F, -23.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(780, 386).addBox(5.0F, -23.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(724, 386).addBox(-7.0F, -24.0F, 15.0F, 12.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(820, 365).addBox(5.0F, -8.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(810, 365).addBox(-10.0F, -8.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(772, 365).addBox(-7.0F, -8.0F, 15.0F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(822, 822).addBox(-11.0F, -20.0F, 15.0F, 20.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(838, 153).addBox(-3.0F, -16.0F, 13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.5F, -10.8F));

		PartDefinition cube_r42 = bone2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(576, 838).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -14.0F, 15.4F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Small = Reactor.addOrReplaceChild("Small", CubeListBuilder.create().texOffs(700, 789).addBox(-5.0F, -21.6F, -1.44F, 10.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(792, 415).addBox(7.5F, -16.0F, -1.44F, 3.0F, 10.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(792, 386).addBox(-5.2F, -3.24F, -1.44F, 10.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(792, 451).addBox(-10.9F, -16.0F, -1.44F, 3.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(78.0F, -2.7F, 22.0F));

		PartDefinition cube_r43 = Small.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(462, 801).addBox(-1.2F, -4.0F, -16.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.18F, -17.9F, 14.4F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r44 = Small.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(116, 806).addBox(-1.2F, -4.0F, -16.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.18F, -3.94F, 14.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r45 = Small.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(58, 806).addBox(-1.8F, -4.0F, -24.4F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7628F, -3.9572F, 22.8F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r46 = Small.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 806).addBox(-1.8F, -4.0F, -20.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7628F, -17.8828F, 18.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition bone3 = Small.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(752, 386).addBox(-4.0F, -19.4F, 30.2F, 13.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(792, 581).addBox(-4.0F, -6.4F, 30.2F, 13.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(826, 167).addBox(-5.4F, -16.4F, 30.2F, 16.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.4F, -10.64F));

		PartDefinition Wheels = main.addOrReplaceChild("Wheels", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -4.4F));

		PartDefinition WingWheelRight = Wheels.addOrReplaceChild("WingWheelRight", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 99.0F));

		PartDefinition cube_r47 = WingWheelRight.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(472, 835).addBox(-2.0F, 7.0F, -3.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -9.8F, -1.6F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r48 = WingWheelRight.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(742, 836).addBox(-2.0F, -7.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -9.8F, -1.6F, 0.2182F, 0.0F, 0.0F));

		PartDefinition wheel5 = WingWheelRight.addOrReplaceChild("wheel5", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.0F));

		PartDefinition wheel4 = WingWheelRight.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -8.0F));

		PartDefinition wheel3 = WingWheelRight.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.0F));

		PartDefinition wheel8 = WingWheelRight.addOrReplaceChild("wheel8", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -8.0F));

		PartDefinition WingWheelLeft = Wheels.addOrReplaceChild("WingWheelLeft", CubeListBuilder.create(), PartPose.offset(-14.0F, 0.0F, 99.0F));

		PartDefinition cube_r49 = WingWheelLeft.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(472, 835).addBox(-2.0F, 7.0F, -3.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -9.8F, -1.6F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r50 = WingWheelLeft.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(742, 836).addBox(-2.0F, -7.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -9.8F, -1.6F, 0.2182F, 0.0F, 0.0F));

		PartDefinition wheel9 = WingWheelLeft.addOrReplaceChild("wheel9", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -1.0F));

		PartDefinition wheel10 = WingWheelLeft.addOrReplaceChild("wheel10", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -8.0F));

		PartDefinition wheel11 = WingWheelLeft.addOrReplaceChild("wheel11", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -1.0F));

		PartDefinition wheel15 = WingWheelLeft.addOrReplaceChild("wheel15", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -8.0F));

		PartDefinition SmallWheel = Wheels.addOrReplaceChild("SmallWheel", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 4.4F));

		PartDefinition cube_r51 = SmallWheel.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(362, 838).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.2F, -3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition wheel2 = SmallWheel.addOrReplaceChild("wheel2", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 15.0F, -9.4F));

		PartDefinition wheel7 = SmallWheel.addOrReplaceChild("wheel7", CubeListBuilder.create().texOffs(268, 841).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(108, 840).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(274, 841).addBox(-1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 15.0F, -9.4F));

		PartDefinition Left = main.addOrReplaceChild("Left", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 191.0F));

		PartDefinition Chassis3 = Left.addOrReplaceChild("Chassis3", CubeListBuilder.create(), PartPose.offset(-21.0F, 0.0F, -215.0F));

		PartDefinition Noze4 = Chassis3.addOrReplaceChild("Noze4", CubeListBuilder.create(), PartPose.offset(22.0F, 0.0F, 22.0F));

		PartDefinition WindShield3 = Noze4.addOrReplaceChild("WindShield3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Fill2 = WindShield3.addOrReplaceChild("Fill2", CubeListBuilder.create().texOffs(284, 841).mirror().addBox(-11.0F, -10.6F, -29.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(280, 841).mirror().addBox(-11.0F, -11.0F, -28.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(830, 365).mirror().addBox(-11.0F, -11.6F, -27.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(186, 841).mirror().addBox(-11.0F, -12.2F, -26.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(174, 841).mirror().addBox(-11.0F, -12.6F, -25.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(802, 840).mirror().addBox(-11.0F, -13.7F, -24.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(786, 840).mirror().addBox(-11.0F, -14.3F, -23.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(452, 840).mirror().addBox(-11.0F, -14.7F, -22.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(436, 840).mirror().addBox(-11.0F, -15.4F, -21.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(418, 840).mirror().addBox(-11.0F, -15.8F, -20.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(396, 840).mirror().addBox(-11.0F, -16.4F, -19.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(380, 840).mirror().addBox(-11.0F, -16.9F, -18.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(628, 838).mirror().addBox(-11.0F, -17.4F, -17.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(620, 838).mirror().addBox(-11.0F, -18.4F, -16.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(358, 838).mirror().addBox(-11.0F, -19.4F, -15.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(826, 836).mirror().addBox(-11.0F, -20.4F, -14.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(774, 836).mirror().addBox(-11.0F, -21.4F, -13.0F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(682, 836).mirror().addBox(-11.0F, -22.7F, -12.0F, 1.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(674, 836).mirror().addBox(-11.0F, -23.7F, -11.0F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(662, 836).mirror().addBox(-11.0F, -24.5F, -10.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(654, 836).mirror().addBox(-11.0F, -25.5F, -9.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(646, 836).mirror().addBox(-11.0F, -26.5F, -8.0F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(516, 835).mirror().addBox(-11.0F, -27.5F, -7.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(460, 835).mirror().addBox(-11.0F, -28.0F, -6.0F, 1.0F, 29.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(762, 836).mirror().addBox(-11.0F, -29.0F, -4.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(830, 836).mirror().addBox(-11.0F, -7.0F, -4.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 0.5F, 0.0F));

		PartDefinition cube_r52 = Fill2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(602, 838).mirror().addBox(-0.5F, -2.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.5F, -10.1F, -4.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r53 = Fill2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(134, 840).mirror().addBox(-0.5F, -3.5F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(124, 840).mirror().addBox(0.1F, -3.5F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -23.4F, 0.9F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r54 = Fill2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(592, 838).mirror().addBox(-0.5F, -5.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(370, 838).mirror().addBox(0.1F, -5.5F, -2.5F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -17.9F, -4.6F, -0.7854F, 0.0F, 0.0F));

		PartDefinition SideWindShield3 = Noze4.addOrReplaceChild("SideWindShield3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition cube_r55 = SideWindShield3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(380, 824).mirror().addBox(-1.0F, 0.0F, -13.0F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, -5.7F, 0.8F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r56 = SideWindShield3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(826, 178).mirror().addBox(-3.0F, -8.0F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -11.5F, -12.6F, 1.5708F, -0.5672F, 0.0F));

		PartDefinition cube_r57 = SideWindShield3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(738, 818).mirror().addBox(-1.0F, -2.0F, -15.0F, 5.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, -22.4F, 1.4F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Fill3 = SideWindShield3.addOrReplaceChild("Fill3", CubeListBuilder.create().texOffs(780, 815).mirror().addBox(-11.0F, -15.0F, -12.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(384, 840).mirror().addBox(-11.0F, -21.0F, -4.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(428, 840).mirror().addBox(-11.0F, -20.0F, -5.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(444, 840).mirror().addBox(-11.0F, -19.0F, -6.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(778, 840).mirror().addBox(-11.0F, -18.0F, -7.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(794, 840).mirror().addBox(-11.0F, -18.0F, -8.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(814, 840).mirror().addBox(-11.0F, -17.0F, -9.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(178, 841).mirror().addBox(-11.0F, -16.0F, -10.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(820, 581).mirror().addBox(-11.0F, -15.0F, -11.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(154, 840).mirror().addBox(-11.0F, -22.0F, -3.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(158, 840).mirror().addBox(-11.0F, -22.0F, -2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(612, 838).mirror().addBox(-11.0F, -23.0F, -1.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(346, 838).mirror().addBox(-11.0F, -24.0F, 0.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.9F, 0.5F, 0.0F));

		PartDefinition FullTail3 = Chassis3.addOrReplaceChild("FullTail3", CubeListBuilder.create(), PartPose.offset(22.0F, 0.0F, 22.0F));

		PartDefinition Tail4 = FullTail3.addOrReplaceChild("Tail4", CubeListBuilder.create(), PartPose.offset(0.0F, -27.0F, 188.0F));

		PartDefinition Fill4 = Tail4.addOrReplaceChild("Fill4", CubeListBuilder.create().texOffs(810, 840).mirror().addBox(-11.0F, 2.9F, 29.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(806, 840).mirror().addBox(-11.0F, 2.5F, 30.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(790, 840).mirror().addBox(-11.0F, 2.6F, 28.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(456, 840).mirror().addBox(-11.0F, 2.4F, 27.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(440, 840).mirror().addBox(-11.0F, 1.9F, 26.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(414, 840).mirror().addBox(-11.0F, 1.7F, 25.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(388, 840).mirror().addBox(-11.0F, 1.4F, 24.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(410, 840).mirror().addBox(-11.0F, 1.7F, 23.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(170, 840).mirror().addBox(-11.0F, 1.3F, 22.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(120, 840).mirror().addBox(-11.0F, 1.2F, 21.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(632, 838).mirror().addBox(-11.0F, 1.6F, 20.0F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(624, 838).mirror().addBox(-11.0F, 1.2F, 19.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(350, 838).mirror().addBox(-11.0F, 1.1F, 18.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(838, 132).mirror().addBox(-11.0F, 0.6F, 17.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(342, 838).mirror().addBox(-11.0F, 1.2F, 16.0F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(822, 836).mirror().addBox(-11.0F, 1.0F, 15.0F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(758, 836).mirror().addBox(-11.0F, 0.4F, 14.0F, 1.0F, 22.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(738, 836).mirror().addBox(-11.0F, 0.4F, 13.0F, 1.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(678, 836).mirror().addBox(-11.0F, 0.0F, 12.0F, 1.0F, 24.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(666, 836).mirror().addBox(-11.0F, -0.3F, 11.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(670, 836).mirror().addBox(-11.0F, -0.1F, 10.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(658, 836).mirror().addBox(-11.0F, -0.3F, 9.0F, 1.0F, 26.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(650, 836).mirror().addBox(-11.0F, -0.5F, 8.0F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 836).mirror().addBox(-11.0F, -0.7F, 7.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(642, 836).mirror().addBox(-11.0F, -0.5F, 6.0F, 1.0F, 28.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(466, 835).mirror().addBox(-11.0F, -1.0F, 4.0F, 1.0F, 29.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(826, 132).mirror().addBox(-11.0F, -1.0F, -1.0F, 1.0F, 30.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, -0.5F, 0.0F));

		PartDefinition TailSide3 = FullTail3.addOrReplaceChild("TailSide3", CubeListBuilder.create(), PartPose.offset(0.0F, -27.0F, 188.0F));

		PartDefinition cube_r58 = TailSide3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(420, 824).mirror().addBox(-1.0F, -2.0F, -1.0F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.9F, 5.7F, -0.7F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r59 = TailSide3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(712, 832).mirror().addBox(-3.0F, -3.0F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 11.5F, 12.6F, 1.5708F, 0.5672F, 0.0F));

		PartDefinition cube_r60 = TailSide3.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(789, 831).mirror().addBox(-2.5F, -1.0F, 1.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.4F, 22.232F, -8.0378F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r61 = TailSide3.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(780, 822).mirror().addBox(-1.0F, 0.0F, -1.0F, 5.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.9F, 22.4F, -0.8F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Fill9 = TailSide3.addOrReplaceChild("Fill9", CubeListBuilder.create().texOffs(824, 581).mirror().addBox(-11.0F, 9.0F, 11.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(392, 840).mirror().addBox(-11.0F, 6.0F, 3.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(432, 840).mirror().addBox(-11.0F, 7.0F, 4.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(448, 840).mirror().addBox(-11.0F, 7.0F, 5.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(782, 840).mirror().addBox(-11.0F, 7.0F, 6.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(798, 840).mirror().addBox(-11.0F, 8.0F, 7.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(818, 840).mirror().addBox(-11.0F, 8.0F, 8.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(182, 841).mirror().addBox(-11.0F, 9.0F, 9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(828, 581).mirror().addBox(-11.0F, 9.0F, 10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(162, 840).mirror().addBox(-11.0F, 6.0F, 2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(166, 840).mirror().addBox(-11.0F, 6.0F, 1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(616, 838).mirror().addBox(-11.0F, 5.0F, 0.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(354, 838).mirror().addBox(-11.0F, 5.0F, -1.0F, 1.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.8F, -0.5F, 0.0F));

		PartDefinition Body3 = Chassis3.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(0, 606).mirror().addBox(-11.0F, -29.0F, 1.0F, 1.0F, 5.0F, 195.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(392, 588).mirror().addBox(-11.0F, -5.0F, 1.0F, 1.0F, 6.0F, 195.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(392, 392).mirror().addBox(-16.0F, -25.0F, 1.0F, 5.0F, 1.0F, 195.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(314, 549).mirror().addBox(-16.0F, -24.0F, 158.0F, 1.0F, 19.0F, 38.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(201, 483).mirror().addBox(-16.0F, -24.0F, 31.0F, 1.0F, 19.0F, 127.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(165, 557).mirror().addBox(-16.0F, -24.0F, 1.0F, 1.0F, 19.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(426, 0).mirror().addBox(-16.0F, -5.0F, 1.0F, 5.0F, 1.0F, 195.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(22.0F, 0.5F, 13.0F));

		PartDefinition cube_r62 = Body3.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(772, 196).mirror().addBox(-2.0F, -3.0F, 77.0F, 3.0F, 6.0F, 73.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(784, 779).mirror().addBox(-5.0F, -10.0F, 48.0F, 6.0F, 14.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(772, 275).mirror().addBox(-2.0F, -3.0F, -20.0F, 3.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.6F, -3.3F, 29.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r63 = Body3.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(392, 789).mirror().addBox(-3.0F, -10.5F, -14.5F, 6.0F, 6.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(784, 739).mirror().addBox(-3.0F, -4.5F, -14.5F, 8.0F, 11.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.4891F, -6.3607F, 91.5F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r64 = Body3.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(426, 196).mirror().addBox(-2.0F, -3.0F, -20.0F, 3.0F, 6.0F, 170.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.6F, -25.6F, 29.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Interieur3 = Left.addOrReplaceChild("Interieur3", CubeListBuilder.create().texOffs(258, 851).mirror().addBox(-22.0F, -18.5F, 19.0F, 4.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(258, 851).mirror().addBox(-22.0F, -18.5F, 165.0F, 4.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -5.0F, -194.0F));

		PartDefinition Lever2 = Interieur3.addOrReplaceChild("Lever2", CubeListBuilder.create(), PartPose.offset(-15.5F, -6.2633F, -10.5689F));

		PartDefinition cube_r65 = Lever2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(230, 900).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1231F, -0.0447F, -0.3463F));

		PartDefinition cube_r66 = Lever2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(230, 900).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, -0.1231F, 0.0447F, 0.3463F));

		PartDefinition cube_r67 = Lever2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(227, 899).mirror().addBox(0.0F, -13.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(226, 900).mirror().addBox(-2.0F, -13.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 13.9633F, 2.5689F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Passagers2 = Interieur3.addOrReplaceChild("Passagers2", CubeListBuilder.create(), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition C3 = Passagers2.addOrReplaceChild("C3", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-9.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 51.0F));

		PartDefinition Dossier_r7 = C3.addOrReplaceChild("Dossier_r7", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C7 = Passagers2.addOrReplaceChild("C7", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-9.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 74.0F));

		PartDefinition Dossier_r8 = C7.addOrReplaceChild("Dossier_r8", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C8 = Passagers2.addOrReplaceChild("C8", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-9.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 143.0F));

		PartDefinition Dossier_r9 = C8.addOrReplaceChild("Dossier_r9", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C9 = Passagers2.addOrReplaceChild("C9", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-9.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 97.0F));

		PartDefinition Dossier_r10 = C9.addOrReplaceChild("Dossier_r10", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition C10 = Passagers2.addOrReplaceChild("C10", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-9.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 120.0F));

		PartDefinition Dossier_r11 = C10.addOrReplaceChild("Dossier_r11", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition ChaiseCommand2 = Interieur3.addOrReplaceChild("ChaiseCommand2", CubeListBuilder.create().texOffs(826, 89).mirror().addBox(-18.5F, 2.0F, -3.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(638, 817).mirror().addBox(-19.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition Dossier_r12 = ChaiseCommand2.addOrReplaceChild("Dossier_r12", CubeListBuilder.create().texOffs(688, 832).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Aero2 = Left.addOrReplaceChild("Aero2", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, -191.0F));

		PartDefinition Elevator2 = Aero2.addOrReplaceChild("Elevator2", CubeListBuilder.create().texOffs(826, 32).mirror().addBox(-119.9F, -6.7F, 113.8F, 7.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(65.9F, -16.1F, 83.2F));

		PartDefinition cube_r68 = Elevator2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(576, 817).mirror().addBox(-17.0F, -0.5F, -13.5F, 11.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-68.3634F, -6.0F, 100.7005F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r69 = Elevator2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(462, 789).mirror().addBox(-50.5F, -0.5F, -10.5F, 34.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-66.5F, -6.0F, 106.5F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r70 = Elevator2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(784, 614).mirror().addBox(-61.5F, -11.5F, -0.5F, 50.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-70.0F, 4.5F, 77.6F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Winglet2 = Aero2.addOrReplaceChild("Winglet2", CubeListBuilder.create().texOffs(380, 806).mirror().addBox(-2.1F, -14.7F, 24.5F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(400, 840).mirror().addBox(-2.1F, -9.7F, 20.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-116.4F, -7.8F, 97.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r71 = Winglet2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(422, 840).mirror().addBox(0.15F, -2.15F, -2.75F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, -19.95F, 31.95F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r72 = Winglet2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(772, 789).mirror().addBox(-3.55F, -5.45F, -0.15F, 1.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.35F, -18.85F, 26.85F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Wing2 = Aero2.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(784, 588).mirror().addBox(-49.0F, -7.0F, 75.0F, 35.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(688, 818).mirror().addBox(-27.0F, -7.0F, 63.0F, 13.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(826, 46).mirror().addBox(-120.0F, -6.7F, 113.8F, 7.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition cube_r73 = Wing2.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(686, 372).mirror().addBox(-50.5F, -0.5F, -12.5F, 76.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-66.5F, -6.0F, 106.5F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r74 = Wing2.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(520, 801).mirror().addBox(55.5F, -12.5F, -0.5F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(426, 372).mirror().addBox(-61.5F, -12.5F, -0.5F, 117.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-66.5F, 4.5F, 83.5F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Reactor2 = Aero2.addOrReplaceChild("Reactor2", CubeListBuilder.create(), PartPose.offset(37.0F, 14.0F, 45.0F));

		PartDefinition Big2 = Reactor2.addOrReplaceChild("Big2", CubeListBuilder.create().texOffs(626, 789).mirror().addBox(-6.0F, -26.5F, -1.8F, 12.0F, 3.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 507).mirror().addBox(-13.0F, -19.5F, -1.8F, 3.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(552, 789).mirror().addBox(-6.0F, -3.3F, -1.8F, 12.0F, 3.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 544).mirror().addBox(10.0F, -19.5F, -1.8F, 3.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-78.0F, 0.0F, 0.0F));

		PartDefinition cube_r75 = Big2.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(286, 806).mirror().addBox(-1.0F, -5.0F, -20.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.1F, -21.5F, 18.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r76 = Big2.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(230, 806).mirror().addBox(-1.0F, -5.0F, -20.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.1F, -5.3F, 18.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r77 = Big2.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(174, 806).mirror().addBox(-1.5F, -5.0F, -30.5F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.4536F, -4.9464F, 28.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r78 = Big2.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(520, 817).mirror().addBox(-1.5F, -5.0F, -25.0F, 3.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.4536F, -21.8536F, 23.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone4 = Big2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(800, 365).mirror().addBox(7.0F, -23.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(780, 386).mirror().addBox(-8.0F, -23.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(724, 386).mirror().addBox(-5.0F, -24.0F, 15.0F, 12.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(820, 365).mirror().addBox(-8.0F, -8.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(810, 365).mirror().addBox(7.0F, -8.0F, 15.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(772, 365).mirror().addBox(-5.0F, -8.0F, 15.0F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(822, 822).mirror().addBox(-9.0F, -20.0F, 15.0F, 20.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(838, 153).mirror().addBox(-1.0F, -16.0F, 13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.5F, -10.8F));

		PartDefinition cube_r79 = bone4.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(576, 838).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -14.0F, 15.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Small2 = Reactor2.addOrReplaceChild("Small2", CubeListBuilder.create().texOffs(700, 789).mirror().addBox(-5.0F, -21.6F, -1.44F, 10.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 415).mirror().addBox(-10.5F, -16.0F, -1.44F, 3.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 386).mirror().addBox(-4.8F, -3.24F, -1.44F, 10.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 451).mirror().addBox(7.9F, -16.0F, -1.44F, 3.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-78.0F, -2.7F, 22.0F));

		PartDefinition cube_r80 = Small2.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(462, 801).mirror().addBox(-1.8F, -4.0F, -16.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.18F, -17.9F, 14.4F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r81 = Small2.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(116, 806).mirror().addBox(-1.8F, -4.0F, -16.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.18F, -3.94F, 14.4F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r82 = Small2.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(58, 806).mirror().addBox(-1.2F, -4.0F, -24.4F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.7628F, -3.9572F, 22.8F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r83 = Small2.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(0, 806).mirror().addBox(-1.2F, -4.0F, -20.0F, 3.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.7628F, -17.8828F, 18.4F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone5 = Small2.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(752, 386).mirror().addBox(-9.0F, -19.4F, 30.2F, 13.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(792, 581).mirror().addBox(-9.0F, -6.4F, 30.2F, 13.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(826, 167).mirror().addBox(-10.6F, -16.4F, 30.2F, 16.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 0.4F, -10.64F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entity.onGround()){
			this.Wheels.visible = true;
		}else {
			this.Wheels.visible = false;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}