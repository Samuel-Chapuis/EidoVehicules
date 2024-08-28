// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

package fr.thoridan.planes.entity.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import fr.thoridan.planes.entity.custom.models.YellowPlane;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

import static java.lang.Math.abs;

public class YellowPlaneModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart YellowPlane;
	private final ModelPart Pales;

	public YellowPlaneModel(ModelPart root) {
		this.YellowPlane = root.getChild("YellowPlane");
		this.Pales = this.YellowPlane.getChild("Helice").getChild("Pales");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition YellowPlane = partdefinition.addOrReplaceChild("YellowPlane", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Helice = YellowPlane.addOrReplaceChild("Helice", CubeListBuilder.create(), PartPose.offset(3.0F, -7.0F, -32.0F));

		PartDefinition Rotor = Helice.addOrReplaceChild("Rotor", CubeListBuilder.create().texOffs(-1, 21).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 30).addBox(-4.0F, -4.0F, 2.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition Pales = Helice.addOrReplaceChild("Pales", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.8453F, 1.5F));

		PartDefinition Pale_r1 = Pales.addOrReplaceChild("Pale_r1", CubeListBuilder.create().texOffs(1, 167).mirror().addBox(-19.0F, -3.0F, -1.0F, 21.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.5F, 7.8453F, -0.5F, 0.0F, 0.0F, 2.618F));

		PartDefinition Pale_r2 = Pales.addOrReplaceChild("Pale_r2", CubeListBuilder.create().texOffs(1, 167).addBox(-2.0F, -3.0F, -1.0F, 21.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, 7.8453F, -0.5F, 0.0F, 0.0F, -2.618F));

		PartDefinition Pale_r3 = Pales.addOrReplaceChild("Pale_r3", CubeListBuilder.create().texOffs(1, 167).addBox(-2.0F, -3.0F, -1.0F, 21.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.1547F, -0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition Root = YellowPlane.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Chaise = Root.addOrReplaceChild("Chaise", CubeListBuilder.create().texOffs(135, 87).addBox(0.0F, 2.0F, -2.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(51, 77).addBox(1.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -1.0F));

		PartDefinition Dossier_r1 = Chaise.addOrReplaceChild("Dossier_r1", CubeListBuilder.create().texOffs(1, 0).addBox(1.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Aile = Root.addOrReplaceChild("Aile", CubeListBuilder.create(), PartPose.offset(2.0F, -33.0F, -22.0F));

		PartDefinition Longeron2_r1 = Aile.addOrReplaceChild("Longeron2_r1", CubeListBuilder.create().texOffs(0, 159).addBox(-1.0F, -2.0F, -1.0F, 45.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 35.0F, 23.0F, 0.0F, 0.2182F, -0.7243F));

		PartDefinition Longeron1_r1 = Aile.addOrReplaceChild("Longeron1_r1", CubeListBuilder.create().texOffs(0, 163).addBox(-1.0F, -2.0F, -1.0F, 43.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 35.0F, 27.0F, 0.0F, 0.0F, -0.7069F));

		PartDefinition Aile_r1 = Aile.addOrReplaceChild("Aile_r1", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 3.0F, 5.0F, 68.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0864F, -0.0038F, 0.0115F));

		PartDefinition Chassis = Root.addOrReplaceChild("Chassis", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, -27.0F));

		PartDefinition Cot_r1 = Chassis.addOrReplaceChild("Cot_r1", CubeListBuilder.create().texOffs(122, 30).addBox(8.0F, -5.0F, -1.0F, 1.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.2F, 4.7F, -1.1606F, 0.0F, 0.0F));

		PartDefinition Exterieur = Chassis.addOrReplaceChild("Exterieur", CubeListBuilder.create().texOffs(1, 77).addBox(0.0F, 7.0F, -32.0F, 9.0F, 3.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(114, 106).addBox(-2.0F, -10.0F, 22.0F, 6.0F, 10.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 36.0F));

		PartDefinition QueuArriere2_r1 = Exterieur.addOrReplaceChild("QueuArriere2_r1", CubeListBuilder.create().texOffs(123, 115).addBox(0.0F, -5.0F, 11.0F, 5.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.0F, 19.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition QueuBasDetail_r1 = Exterieur.addOrReplaceChild("QueuBasDetail_r1", CubeListBuilder.create().texOffs(65, 30).addBox(0.0F, 2.0F, -1.0F, 9.0F, 3.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.2629F, -0.0832F, -0.0263F));

		PartDefinition QueuBas_r1 = Exterieur.addOrReplaceChild("QueuBas_r1", CubeListBuilder.create().texOffs(77, 68).addBox(2.0F, 3.0F, -1.0F, 10.0F, 4.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, 0.265F, -0.1506F, -0.0446F));

		PartDefinition QueuHautPrincipale_r1 = Exterieur.addOrReplaceChild("QueuHautPrincipale_r1", CubeListBuilder.create().texOffs(54, 106).addBox(2.0F, -3.0F, -16.0F, 2.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, -8.8F, 22.0F, -0.2895F, -0.1607F, -0.0904F));

		PartDefinition QueuHaut_r1 = Exterieur.addOrReplaceChild("QueuHaut_r1", CubeListBuilder.create().texOffs(10, 39).addBox(0.0F, 3.0F, 5.0F, 9.0F, 2.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.0F, -4.0F, -0.3043F, -0.0658F, 0.0242F));

		PartDefinition ChassisArriere1_r1 = Exterieur.addOrReplaceChild("ChassisArriere1_r1", CubeListBuilder.create().texOffs(134, 137).addBox(10.0F, -17.0F, -1.0F, 2.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2597F, -0.0338F, -0.1265F));

		PartDefinition Cockpit = Chassis.addOrReplaceChild("Cockpit", CubeListBuilder.create().texOffs(96, 115).addBox(-7.0F, -5.0F, -27.0F, 14.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(136, 71).addBox(0.0F, 4.0F, -32.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 36.0F));

		PartDefinition Parbrise_r1 = Cockpit.addOrReplaceChild("Parbrise_r1", CubeListBuilder.create().texOffs(91, 30).addBox(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -6.0F, -28.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Arriere_r1 = Cockpit.addOrReplaceChild("Arriere_r1", CubeListBuilder.create().texOffs(65, 30).addBox(0.0F, -18.0F, -1.0F, 9.0F, 26.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Nez = Chassis.addOrReplaceChild("Nez", CubeListBuilder.create().texOffs(87, 106).addBox(0.0F, -5.0F, -1.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(121, 48).addBox(0.0F, -8.0F, -1.0F, 6.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Moteur_r1 = Nez.addOrReplaceChild("Moteur_r1", CubeListBuilder.create().texOffs(76, 144).addBox(-1.0F, -2.0F, -5.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.086F, -5.0213F, 5.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Dessous_r1 = Nez.addOrReplaceChild("Dessous_r1", CubeListBuilder.create().texOffs(139, 30).addBox(0.0F, -7.0F, -1.0F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.25F, 4.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Aileron = Chassis.addOrReplaceChild("Aileron", CubeListBuilder.create(), PartPose.offset(1.0F, -17.0F, 42.0F));

		PartDefinition Grand_r1 = Aileron.addOrReplaceChild("Grand_r1", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -15.0F, 6.0F, 1.0F, 20.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 16.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Petit_r1 = Aileron.addOrReplaceChild("Petit_r1", CubeListBuilder.create().texOffs(1, 110).addBox(1.0F, -23.0F, 14.0F, 0.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5632F, -0.0612F, 0.0184F));

		PartDefinition RouesAvant = Root.addOrReplaceChild("RouesAvant", CubeListBuilder.create().texOffs(50, 83).addBox(14.0F, 4.0F, -17.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tige_r1 = RouesAvant.addOrReplaceChild("Tige_r1", CubeListBuilder.create().texOffs(2, 155).addBox(-1.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 3.0F, -12.0F, 0.0F, 0.3927F, 0.8727F));

		PartDefinition Infill = Root.addOrReplaceChild("Infill", CubeListBuilder.create().texOffs(34, 110).addBox(3.0F, 5.0F, -10.0F, 4.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(87, 77).addBox(3.0F, 5.0F, -12.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(49, 143).addBox(3.0F, 10.0F, -14.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(1, 77).addBox(3.0F, 3.0F, -2.0F, 4.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(1, 120).addBox(3.0F, 1.0F, -11.0F, 4.0F, 5.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(104, 137).addBox(3.0F, -2.0F, -9.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(22, 40).addBox(3.0F, -4.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -20.0F, 23.0F));

		PartDefinition Root2 = YellowPlane.addOrReplaceChild("Root2", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition Chaise2 = Root2.addOrReplaceChild("Chaise2", CubeListBuilder.create().texOffs(135, 87).mirror().addBox(-4.0F, 2.0F, -2.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(51, 77).mirror().addBox(-10.0F, -1.0F, -7.0F, 9.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -5.0F, -1.0F));

		PartDefinition Dossier_r2 = Chaise2.addOrReplaceChild("Dossier_r2", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-10.0F, -15.0F, -1.0F, 9.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Aile2 = Root2.addOrReplaceChild("Aile2", CubeListBuilder.create(), PartPose.offset(-2.0F, -33.0F, -22.0F));

		PartDefinition Longeron3_r1 = Aile2.addOrReplaceChild("Longeron3_r1", CubeListBuilder.create().texOffs(0, 159).mirror().addBox(-44.0F, -2.0F, -1.0F, 45.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 35.0F, 23.0F, 0.0F, -0.2182F, 0.7243F));

		PartDefinition Longeron2_r2 = Aile2.addOrReplaceChild("Longeron2_r2", CubeListBuilder.create().texOffs(0, 163).mirror().addBox(-42.0F, -2.0F, -1.0F, 43.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 35.0F, 27.0F, 0.0F, 0.0F, 0.7069F));

		PartDefinition Aile_r2 = Aile2.addOrReplaceChild("Aile_r2", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-68.0F, 3.0F, 5.0F, 68.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0864F, 0.0038F, -0.0115F));

		PartDefinition Chassis2 = Root2.addOrReplaceChild("Chassis2", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, -27.0F));

		PartDefinition Cot_r2 = Chassis2.addOrReplaceChild("Cot_r2", CubeListBuilder.create().texOffs(122, 30).mirror().addBox(-9.0F, -5.0F, -1.0F, 1.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.2F, 4.7F, -1.1606F, 0.0F, 0.0F));

		PartDefinition Exterieur2 = Chassis2.addOrReplaceChild("Exterieur2", CubeListBuilder.create().texOffs(1, 77).mirror().addBox(-9.0F, 7.0F, -32.0F, 9.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(114, 106).mirror().addBox(-4.0F, -10.0F, 22.0F, 6.0F, 10.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 36.0F));

		PartDefinition QueuArriere3_r1 = Exterieur2.addOrReplaceChild("QueuArriere3_r1", CubeListBuilder.create().texOffs(123, 115).mirror().addBox(-5.0F, -5.0F, 11.0F, 5.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -5.0F, 19.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition QueuBasDetail_r2 = Exterieur2.addOrReplaceChild("QueuBasDetail_r2", CubeListBuilder.create().texOffs(65, 30).mirror().addBox(-9.0F, 2.0F, -1.0F, 9.0F, 3.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.2629F, 0.0832F, 0.0263F));

		PartDefinition QueuBas_r2 = Exterieur2.addOrReplaceChild("QueuBas_r2", CubeListBuilder.create().texOffs(77, 68).mirror().addBox(-12.0F, 3.0F, -1.0F, 10.0F, 4.0F, 34.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, 0.265F, 0.1506F, 0.0446F));

		PartDefinition QueuHautPrincipale_r2 = Exterieur2.addOrReplaceChild("QueuHautPrincipale_r2", CubeListBuilder.create().texOffs(54, 106).mirror().addBox(-4.0F, -3.0F, -16.0F, 2.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1F, -8.8F, 22.0F, -0.2895F, 0.1607F, 0.0904F));

		PartDefinition QueuHaut_r2 = Exterieur2.addOrReplaceChild("QueuHaut_r2", CubeListBuilder.create().texOffs(10, 39).mirror().addBox(-9.0F, 3.0F, 5.0F, 9.0F, 2.0F, 35.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -25.0F, -4.0F, -0.3043F, 0.0658F, -0.0242F));

		PartDefinition ChassisArriere2_r1 = Exterieur2.addOrReplaceChild("ChassisArriere2_r1", CubeListBuilder.create().texOffs(134, 137).mirror().addBox(-12.0F, -17.0F, -1.0F, 2.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2597F, 0.0338F, 0.1265F));

		PartDefinition Cockpit2 = Chassis2.addOrReplaceChild("Cockpit2", CubeListBuilder.create().texOffs(136, 71).mirror().addBox(-8.0F, 4.0F, -32.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 36.0F));

		PartDefinition Parbrise_r2 = Cockpit2.addOrReplaceChild("Parbrise_r2", CubeListBuilder.create().texOffs(91, 30).mirror().addBox(-1.0F, -16.0F, -1.0F, 1.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -6.0F, -28.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Arriere_r2 = Cockpit2.addOrReplaceChild("Arriere_r2", CubeListBuilder.create().texOffs(65, 30).mirror().addBox(-9.0F, -18.0F, -1.0F, 9.0F, 26.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Nez2 = Chassis2.addOrReplaceChild("Nez2", CubeListBuilder.create().texOffs(87, 106).mirror().addBox(-10.0F, -5.0F, -1.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(121, 48).mirror().addBox(-6.0F, -8.0F, -1.0F, 6.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Moteur_r2 = Nez2.addOrReplaceChild("Moteur_r2", CubeListBuilder.create().texOffs(76, 144).mirror().addBox(-2.0F, -2.0F, -5.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.086F, -5.0213F, 5.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Dessous_r2 = Nez2.addOrReplaceChild("Dessous_r2", CubeListBuilder.create().texOffs(139, 30).mirror().addBox(-9.0F, -7.0F, -1.0F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.25F, 4.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Aileron2 = Chassis2.addOrReplaceChild("Aileron2", CubeListBuilder.create(), PartPose.offset(-1.0F, -17.0F, 42.0F));

		PartDefinition Grand_r2 = Aileron2.addOrReplaceChild("Grand_r2", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-1.0F, -15.0F, 6.0F, 1.0F, 20.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.0F, 16.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Petit_r2 = Aileron2.addOrReplaceChild("Petit_r2", CubeListBuilder.create().texOffs(1, 110).mirror().addBox(-1.0F, -23.0F, 14.0F, 0.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5632F, 0.0612F, -0.0184F));

		PartDefinition RouesAvant2 = Root2.addOrReplaceChild("RouesAvant2", CubeListBuilder.create().texOffs(50, 83).mirror().addBox(-16.0F, 4.0F, -17.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tige_r2 = RouesAvant2.addOrReplaceChild("Tige_r2", CubeListBuilder.create().texOffs(2, 155).mirror().addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 3.0F, -12.0F, 0.0F, -0.3927F, -0.8727F));

		PartDefinition Infill2 = Root2.addOrReplaceChild("Infill2", CubeListBuilder.create().texOffs(34, 110).mirror().addBox(-7.0F, 5.0F, -10.0F, 4.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(87, 77).mirror().addBox(-7.0F, 5.0F, -12.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(49, 143).mirror().addBox(-7.0F, 10.0F, -14.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(1, 77).mirror().addBox(-7.0F, 3.0F, -2.0F, 4.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(1, 120).mirror().addBox(-7.0F, 1.0F, -11.0F, 4.0F, 5.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(104, 137).mirror().addBox(-7.0F, -2.0F, -9.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(22, 40).mirror().addBox(-7.0F, -4.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -20.0F, 23.0F));

		PartDefinition RoueArriere = YellowPlane.addOrReplaceChild("RoueArriere", CubeListBuilder.create().texOffs(50, 83).addBox(2.0F, 3.0F, 20.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = RoueArriere.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(95, 156).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 15.0F, -0.5194F, 0.0687F, -0.0246F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		YellowPlane plane = (YellowPlane) entity;
		if (plane.isBeingControlled()) {
			// Met à jour la rotation de l’hélice pour l'entité contrôlée
			this.Pales.zRot = plane.getPropellerRotation();
		} else {
			// Garde l’hélice immobile pour les autres entités
			this.Pales.zRot = 0;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		YellowPlane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return YellowPlane;
	}
}