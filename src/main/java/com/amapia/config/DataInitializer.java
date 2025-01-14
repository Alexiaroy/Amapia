package com.amapia.config;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.amapia.entity.Activity;
import com.amapia.entity.Admin;
import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Enterprise;
import com.amapia.entity.Individual;
import com.amapia.entity.Member;
import com.amapia.entity.MemberType;
import com.amapia.entity.Order;
import com.amapia.entity.OrderLine;
import com.amapia.entity.Producer;
import com.amapia.entity.Product;
import com.amapia.entity.Subscription;
import com.amapia.entity.Volunteer;
import com.amapia.repository.AdminRepository;
import com.amapia.repository.OrderLineRepository;
import com.amapia.repository.OrderRepository;
import com.amapia.repository.ProductRepository;
import com.amapia.repository.SubscriptionRepository;
import com.amapia.service.ActivityService;
import com.amapia.service.AmapAccountService;
import com.amapia.service.BasketService;
import com.amapia.service.MemberService;
import com.amapia.service.ProductService;
import com.amapia.service.VolunteerService;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	private final SubscriptionRepository subscriptionRepository;
	private final AmapAccountService amapAccountService;

	private final MemberService memberService;
	private final ProductService productService;
	private final ActivityService activityService;
	private final OrderRepository orderRepository;
	private final BasketService basketService;
	private final OrderLineRepository orderlineRepository;

	private final AdminRepository adminRepo;

	public DataInitializer(SubscriptionRepository subscriptionRepository, AmapAccountService amapAccountService,
			MemberService memberService, ProductService productService, ActivityService activityService,
			OrderRepository orderRepository, OrderLineRepository orderlineRepository,
			ProductRepository productRepository, AdminRepository adminRepo, BasketService basketService) {

		this.subscriptionRepository = subscriptionRepository;
		this.amapAccountService = amapAccountService;
		this.memberService = memberService;
		this.productService = productService;
		this.activityService = activityService;

		this.basketService = basketService;

		this.orderRepository = orderRepository;
		this.orderlineRepository = orderlineRepository;

		this.adminRepo = adminRepo;

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (subscriptionRepository.count() == 0) {
			Admin admin = new Admin();
			admin.setEmail("contact.amapia@gmail.com");
			admin.setPassword("AmapiaAdmin");
			adminRepo.save(admin);
			
			Subscription basicSubscription = new Subscription();
			basicSubscription.setSubscriptionName("Basic");
			basicSubscription.setPrice(new BigDecimal("19.99"));
			basicSubscription.setId(1L);

			Subscription standardSubscription = new Subscription();
			standardSubscription.setSubscriptionName("Standard");
			standardSubscription.setPrice(new BigDecimal("29.99"));
			standardSubscription.setId(2L);

			Subscription premiumSubscription = new Subscription();
			premiumSubscription.setSubscriptionName("Premium");
			premiumSubscription.setPrice(new BigDecimal("39.99"));
			premiumSubscription.setId(3L);

			Subscription noSubscription = new Subscription();
			noSubscription.setSubscriptionName("Sans Abonnement");
			noSubscription.setPrice(new BigDecimal("00.01"));
			noSubscription.setId(4L);
			
			subscriptionRepository.save(basicSubscription);
			subscriptionRepository.save(standardSubscription);
			subscriptionRepository.save(premiumSubscription);
			subscriptionRepository.save(noSubscription);



			// -----Datas needed for the presentation-----
			
			Amap solidaireAMAP = new Amap("SolidaireAMAP", "22 Rue de la Solidarité 75005 Paris", "Lemoine", "Antoine", "0156702098", "alemoine@solidaireamap.fr", "securepassword", "876 543 210 00045");
	        Timestamp timestampSolidaireAMAPPayment = Timestamp.valueOf("2024-12-18 11:10:06.211000");
	        solidaireAMAP.setSubLastPaymentDate(timestampSolidaireAMAPPayment);
	        solidaireAMAP.setSubscription(premiumSubscription);
	        Timestamp timestampSolidaireAMAP = Timestamp.valueOf("2024-08-18 11:10:06.211000");
	        solidaireAMAP.setDateCreated(timestampSolidaireAMAP);
	        amapAccountService.save(solidaireAMAP);
	        
	        Amap terreVerte = new Amap("Terre Verte", "15 Avenue des Champs 75011 Paris", "Fournier", "Sophie", "0187956321", "sfournier@terreverte.fr", "root@1234", "321 654 987 00056");
	        Timestamp timestampTerreVertePayment = Timestamp.valueOf("2025-01-05 11:10:06.211000");
	        terreVerte.setSubLastPaymentDate(timestampTerreVertePayment);
	        terreVerte.setSubscription(basicSubscription);
	        Timestamp timestampTerreVerte = Timestamp.valueOf("2024-10-05 11:10:06.211000");
	        terreVerte.setDateCreated(timestampTerreVerte);
	        amapAccountService.save(terreVerte);
	        
	        Amap bioJardin = new Amap("BioJardin", "34 Rue de la Nature 75003 Paris", "Rousseau", "Michel", "0176584930", "mrousseau@biojardin.fr", "mypassword123", "123 987 654 00067");
	        Timestamp timestampBioJardinPayment = Timestamp.valueOf("2024-12-25 11:10:06.211000");
	        bioJardin.setSubLastPaymentDate(timestampBioJardinPayment);
	        bioJardin.setSubscription(standardSubscription);
	        Timestamp timestampBioJardin = Timestamp.valueOf("2024-07-25 11:10:06.211000");
	        bioJardin.setDateCreated(timestampBioJardin);
	        amapAccountService.save(bioJardin);
	        
	        Amap amapNature = new Amap("Amap Nature", "5 Rue du Jardin 75006 Paris", "Bernard", "Elise", "0185432123", "ebernard@amapnature.fr", "elise1234", "543 210 987 00089");
	        amapNature.setSubLastPaymentDate(Timestamp.valueOf("2024-12-30 11:10:06.211000"));
	        amapNature.setSubscription(standardSubscription);
	        amapNature.setDateCreated(Timestamp.valueOf("2024-08-30 11:10:06.211000"));
	        amapAccountService.save(amapNature);
	        
	        Amap amapFleur = new Amap("Amap Fleur", "29 Rue des Fleurs 75009 Paris", "Lemoine", "Sophie", "0178956321", "sophie@amapfleur.fr", "sophie1234", "987 654 321 00111");
	        amapFleur.setSubLastPaymentDate(Timestamp.valueOf("2024-12-01 11:10:06.211000"));
	        amapFleur.setSubscription(standardSubscription);
	        amapFleur.setDateCreated(Timestamp.valueOf("2024-08-01 11:10:06.211000"));
	        amapAccountService.save(amapFleur);
	        
	        Amap amapSolidaire = new Amap("Amap Solidaire", "23 Rue de l'Aide 75010 Paris", "Dupont", "Michel", "0164537890", "michel@amapsolidaire.fr", "michelpass!", "123 456 789 00112");
	        amapSolidaire.setSubLastPaymentDate(Timestamp.valueOf("2025-01-05 11:10:06.211000"));
	        amapSolidaire.setSubscription(premiumSubscription);
	        amapSolidaire.setDateCreated(Timestamp.valueOf("2024-09-05 11:10:06.211000"));
	        amapAccountService.save(amapSolidaire);
	        
	        Amap amapPaysanne = new Amap("Amap Paysanne", "9 Rue des Champs 75013 Paris", "Rousseau", "Antoine", "0194768592", "arousseau@amappaysanne.fr", "root1234", "543 210 987 00134");
	        amapPaysanne.setSubLastPaymentDate(Timestamp.valueOf("2024-12-20 11:10:06.211000"));
	        amapPaysanne.setSubscription(standardSubscription);
	        amapPaysanne.setDateCreated(Timestamp.valueOf("2024-09-20 11:10:06.211000"));
	        amapAccountService.save(amapPaysanne);
	        
	        Amap amapVie = new Amap("Amap Vie", "8 Rue de la Vie 75008 Paris", "Lemoine", "Pierre", "0134928765", "plmoine@amapvie.fr", "pierre@123", "321 654 987 00100");
	        amapVie.setSubLastPaymentDate(Timestamp.valueOf("2025-01-10 11:10:06.211000"));
	        amapVie.setSubscription(basicSubscription);
	        amapVie.setDateCreated(Timestamp.valueOf("2024-10-10 11:10:06.211000"));
	        amapAccountService.save(amapVie);
	        
	        Amap amapEco = new Amap("Amap Eco", "7 Rue de l'Ecologie 75007 Paris", "Leclerc", "Nicolas", "0193456789", "nleclerc@amapeco.fr", "nicolas123!", "678 543 210 00090");
	        amapEco.setSubLastPaymentDate(Timestamp.valueOf("2025-01-01 11:10:06.211000"));
	        amapEco.setSubscription(premiumSubscription);
	        amapEco.setDateCreated(Timestamp.valueOf("2024-11-01 11:10:06.211000"));
	        amapAccountService.save(amapEco);
	        
	        Amap amapJardin = new Amap("Amap Jardin", "55 Rue des Plantes 75012 Paris", "Boulanger", "Marie", "0145609832", "marie@amapjardin.fr", "marie1234", "987 654 321 00123");
	        amapJardin.setSubLastPaymentDate(Timestamp.valueOf("2025-01-10 11:10:06.211000"));
	        amapJardin.setSubscription(basicSubscription);
	        amapJardin.setDateCreated(Timestamp.valueOf("2024-11-10 11:10:06.211000"));
	        amapAccountService.save(amapJardin);
	        
	        Amap lesCultivateurs = new Amap("Les Cultivateurs", "51 Rue des Cultures 75004 Paris", "Boulanger", "Caroline", "0142367821", "cboulanger@lescultivateurs.fr", "newpassword123", "432 109 876 00078");
	        lesCultivateurs.setSubLastPaymentDate(Timestamp.valueOf("2024-12-15 11:10:06.211000"));
	        lesCultivateurs.setSubscription(basicSubscription);
	        lesCultivateurs.setDateCreated(Timestamp.valueOf("2024-11-15 11:10:06.211000"));
	        amapAccountService.save(lesCultivateurs);
	        
			Amap biocoli = new Amap("Biocoli", "14 rue Bouquelot 77160 Provins", "Laajaj", "Soumaya", "0143258073",
					"soumaya.laajaj@hotmail.fr", "root123!", "73282932000074");
			
			Timestamp timestampBiocoliPayment = Timestamp.valueOf("2024-12-15 11:10:06.211000");
			biocoli.setSubLastPaymentDate(timestampBiocoliPayment);
			biocoli.setSubscription(premiumSubscription);
			
			Timestamp timestampBiocoli = Timestamp.valueOf("2024-12-15 11:10:06.211000");
			biocoli.setDateCreated(timestampBiocoli);
			
			biocoli.setNews("Ce mois-ci, Biocoli met à l’honneur les courges d’automne et les légumes racines, parfaits pour vos soupes et plats mijotés. À cette occasion, nous organisons un atelier cuisine le samedi 20 janvier pour apprendre à sublimer ces produits de saison avec des recettes simples et gourmandes.<br><br>"
					+ "Côté producteurs, nous sommes ravis d’accueillir un nouveau partenaire : La Ferme des Chênes Verts, qui nous fournira désormais des œufs bio et des fromages fermiers. Enfin, n’oubliez pas de participer à notre collecte solidaire en partenariat avec les Restos du Cœur : déposez vos surplus ou dons alimentaires lors de la distribution des paniers chaque jeudi.<br><br>"
					+ "Rejoignez-nous pour célébrer le mois de janvier dans la convivialité et le partage !");
			
			biocoli.setAboutSectionTitle("À propos de nous ...");
			biocoli.setAboutSectionText("Biocoli, c’est avant tout une aventure humaine qui met en lumière les richesses de notre territoire. Depuis 2015, nous œuvrons pour connecter les consommateurs soucieux de leur alimentation à des producteurs locaux engagés. Située au cœur de notre région, Biocoli regroupe une communauté de familles et de partenaires qui partagent une même vision : promouvoir une agriculture respectueuse de l’environnement et accessible à tous.<br><br>"
					+ "Nos producteurs travaillent selon des pratiques écologiques et artisanales, privilégiant la qualité des produits et le respect des cycles naturels. À travers nos paniers, nous souhaitons réduire les intermédiaires et garantir une rémunération juste aux agriculteurs. Chez Biocoli, chaque adhérent contribue activement à la pérennité de notre AMAP, que ce soit en participant à la distribution des paniers ou en soutenant nos initiatives locales.<br><br>"
					+ "Engagez-vous avec nous dans cette démarche écoresponsable et savourez des produits frais, locaux et de saison tout au long de l’année. Ensemble, construisons un modèle durable qui soutient nos agriculteurs et valorise notre territoire.");
			
			biocoli.setSubSectionTitle("Fonctionnement des abonnements paniers");
			biocoli.setSubSectionText("Chez Biocoli, la simplicité est au cœur de notre fonctionnement. Les abonnements aux paniers se font pour une saison complète (3 mois) afin de garantir un approvisionnement stable et durable pour nos producteurs. Vous choisissez la taille de votre panier (petit, moyen ou grand), ainsi que la fréquence de livraison : hebdomadaire ou bihebdomadaire.<br><br>"
					+ "Les paniers sont à récupérer chaque jeudi entre 17h et 19h dans notre local situé en centre-ville. Nous encourageons chaque adhérent à participer à une ou deux permanences par saison, contribuant ainsi à la distribution et au bon fonctionnement de l’AMAP. En cas d’empêchement, vous pouvez demander à un proche de récupérer votre panier ou nous prévenir à l’avance pour le redistribuer.<br><br>"
					+ "Avec Biocoli, profitez de produits frais et savoureux tout en soutenant nos agriculteurs locaux.");
			
			amapAccountService.save(biocoli);

			Member jacqueline = new Member("Jaqueline", "Fournier", "jacky@ferme-fournier.com", "producer123!",
					"5 route du Grand Fleigny 77160 Rouilly", "0142567890", new Date(), new Date(), biocoli,
					MemberType.PRODUCER);
			jacqueline.setMemberShipFee(true);
			jacqueline.setAccountStatus(true);

			Producer fermeFournier = new Producer();
			fermeFournier.setProducerCompanyName("Ferme Fournier");
			fermeFournier.setProducerSiret("654 987 321 00044");
			jacqueline.setProducer(fermeFournier);

			memberService.save(jacqueline);

			Member thomas = new Member("Thomas", "Fauchon", "t.fauchon@gmail.com", "producer123!",
					"2 rue du Durteint 77160 Poigny", "0134592231", new Date(), new Date(), biocoli,
					MemberType.PRODUCER);
			thomas.setMemberShipFee(true);
			thomas.setAccountStatus(true);

			Producer vergerDurteint = new Producer();
			vergerDurteint.setProducerCompanyName("Les vergers Durteint");
			vergerDurteint.setProducerSiret("491 234 567 00034");
			thomas.setProducer(vergerDurteint);

			memberService.save(thomas);

			Product cidreDeLaFermeFournier = new Product();
			cidreDeLaFermeFournier.setName("Cidre artisanal");
			cidreDeLaFermeFournier.setActive(true);
			cidreDeLaFermeFournier
					.setDescription("Un cidre artisanal bio, élaboré à partir de pommes locales. Bouteille d'1,5L.");
			cidreDeLaFermeFournier.setPrice(12.50);
			cidreDeLaFermeFournier.setStock(100);
			cidreDeLaFermeFournier.setProducer(fermeFournier);

			ClassPathResource pathCider = new ClassPathResource("datasImages/cidre.png");

			if (!pathCider.exists()) {
				throw new RuntimeException("Fichier introuvable dans le classpath : datasImages/cidre.png");
			}

			try (InputStream inputStream = pathCider.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageCider = new MockMultipartFile("file", pathCider.getFilename(), "image/png",
						imageData);

				productService.saveProduct(cidreDeLaFermeFournier, imageCider);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product huileDeLaFermeFournier = new Product();
			huileDeLaFermeFournier.setName("Huile d'olive");
			huileDeLaFermeFournier.setActive(true);
			huileDeLaFermeFournier.setDescription(
					"Huile d'olive vierge extra issue d'une production artisanale, pressée à froid pour préserver toute la richesse de ses arômes.");
			huileDeLaFermeFournier.setPrice(8.90);
			huileDeLaFermeFournier.setProducer(fermeFournier);

			ClassPathResource pathOliveOil = new ClassPathResource("datasImages/huile-olive.png");
			try (InputStream inputStream = pathOliveOil.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageOliveOil = new MockMultipartFile("file", pathOliveOil.getFilename(), "image/png",
						imageData);

				productService.saveProduct(huileDeLaFermeFournier, imageOliveOil);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product oeufsFermiers = new Product();
			oeufsFermiers.setName("Oeufs frais de la ferme");
			oeufsFermiers.setActive(true);
			oeufsFermiers.setDescription("Oeufs bio de poules élevées en plein air. Boîte de 12 oeufs.");
			oeufsFermiers.setPrice(4.50);
			oeufsFermiers.setStock(200);
			oeufsFermiers.setProducer(vergerDurteint);

			ClassPathResource pathEggs = new ClassPathResource("datasImages/oeufs.png");
			try (InputStream inputStream = pathEggs.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageEggs = new MockMultipartFile("file", pathEggs.getFilename(), "image/png", imageData);
				productService.saveProduct(oeufsFermiers, imageEggs);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product compotePommes = new Product();
			compotePommes.setName("Compote de pommes bio");
			compotePommes.setActive(true);
			compotePommes.setDescription("Une compote de pommes bio sans sucre ajouté. Pot de 500g.");
			compotePommes.setPrice(3.90);
			compotePommes.setStock(150);
			compotePommes.setProducer(fermeFournier);

			ClassPathResource pathCompote = new ClassPathResource("datasImages/compote.png");
			try (InputStream inputStream = pathCompote.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageCompote = new MockMultipartFile("file", pathCompote.getFilename(), "image/png",
						imageData);
				productService.saveProduct(compotePommes, imageCompote);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product confitureFraise = new Product();
			confitureFraise.setName("Confiture de fraises maison");
			confitureFraise.setActive(true);
			confitureFraise
					.setDescription("Confiture artisanale de fraises, préparée avec des fruits locaux. Pot de 250g.");
			confitureFraise.setPrice(5.50);
			confitureFraise.setStock(120);
			confitureFraise.setProducer(vergerDurteint);

			ClassPathResource pathStrawberryJam = new ClassPathResource("datasImages/confiture-fraise.png");
			try (InputStream inputStream = pathStrawberryJam.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageStrawberryJam = new MockMultipartFile("file", pathStrawberryJam.getFilename(),
						"image/png", imageData);
				productService.saveProduct(confitureFraise, imageStrawberryJam);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product marmeladeOrange = new Product();
			marmeladeOrange.setName("Marmelade d'orange bio");
			marmeladeOrange.setActive(true);
			marmeladeOrange.setDescription("Marmelade d'orange bio, légèrement acidulée. Pot de 250g.");
			marmeladeOrange.setPrice(4.80);
			marmeladeOrange.setStock(100);
			marmeladeOrange.setProducer(fermeFournier);

			ClassPathResource pathMarmalade = new ClassPathResource("datasImages/marmelade.png");
			try (InputStream inputStream = pathMarmalade.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageMarmalade = new MockMultipartFile("file", pathMarmalade.getFilename(), "image/png",
						imageData);
				productService.saveProduct(marmeladeOrange, imageMarmalade);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product mielLavande = new Product();
			mielLavande.setName("Miel de lavande");
			mielLavande.setActive(true);
			mielLavande.setDescription("Miel bio de lavande, récolté dans les collines provençales. Pot de 500g.");
			mielLavande.setPrice(8.00);
			mielLavande.setStock(80);
			mielLavande.setProducer(fermeFournier);

			ClassPathResource pathHoney = new ClassPathResource("datasImages/miel.png");
			try (InputStream inputStream = pathHoney.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageHoney = new MockMultipartFile("file", pathHoney.getFilename(), "image/png",
						imageData);
				productService.saveProduct(mielLavande, imageHoney);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product fromageChevre = new Product();
			fromageChevre.setName("Fromage de chèvre frais");
			fromageChevre.setActive(true);
			fromageChevre.setDescription("Fromage de chèvre bio, doux et crémeux. Portion de 200g.");
			fromageChevre.setPrice(6.20);
			fromageChevre.setStock(60);
			fromageChevre.setProducer(vergerDurteint);

			ClassPathResource pathGoatCheese = new ClassPathResource("datasImages/fromage.png");
			try (InputStream inputStream = pathGoatCheese.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageGoatCheese = new MockMultipartFile("file", pathGoatCheese.getFilename(), "image/png",
						imageData);
				productService.saveProduct(fromageChevre, imageGoatCheese);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product pateCampagne = new Product();
			pateCampagne.setName("Pâté de campagne maison");
			pateCampagne.setActive(true);
			pateCampagne.setDescription("Pâté de campagne traditionnel préparé avec des viandes locales. Pot de 200g.");
			pateCampagne.setPrice(7.50);
			pateCampagne.setStock(50);
			pateCampagne.setProducer(vergerDurteint);

			ClassPathResource pathPate = new ClassPathResource("datasImages/pate.png");
			try (InputStream inputStream = pathPate.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imagePate = new MockMultipartFile("file", pathPate.getFilename(), "image/png", imageData);
				productService.saveProduct(pateCampagne, imagePate);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product jusPomme = new Product();
			jusPomme.setName("Jus de pomme artisanal");
			jusPomme.setActive(true);
			jusPomme.setDescription("Jus de pomme bio, sans sucre ajouté, pressé à froid. Bouteille d'1L.");
			jusPomme.setPrice(3.50);
			jusPomme.setStock(120);
			jusPomme.setProducer(vergerDurteint);

			ClassPathResource pathAppleJuice = new ClassPathResource("datasImages/jus-pomme.png");
			try (InputStream inputStream = pathAppleJuice.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageAppleJuice = new MockMultipartFile("file", pathAppleJuice.getFilename(), "image/png",
						imageData);
				productService.saveProduct(jusPomme, imageAppleJuice);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product saucissonSec = new Product();
			saucissonSec.setName("Saucisson sec fermier");
			saucissonSec.setActive(true);
			saucissonSec
					.setDescription("Saucisson sec fermier, préparé avec du porc élevé en plein air. Environ 300g.");
			saucissonSec.setPrice(9.00);
			saucissonSec.setStock(70);
			saucissonSec.setProducer(fermeFournier);

			ClassPathResource pathSaucisson = new ClassPathResource("datasImages/saucisson.png");
			try (InputStream inputStream = pathSaucisson.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageSaucisson = new MockMultipartFile("file", pathSaucisson.getFilename(), "image/png",
						imageData);
				productService.saveProduct(saucissonSec, imageSaucisson);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Product tisaneRelaxante = new Product();
			tisaneRelaxante.setName("Tisane relaxante bio");
			tisaneRelaxante.setActive(true);
			tisaneRelaxante.setDescription("Mélange de plantes bio pour une infusion relaxante. Sachet de 100g.");
			tisaneRelaxante.setPrice(5.90);
			tisaneRelaxante.setStock(90);
			tisaneRelaxante.setProducer(vergerDurteint);

			ClassPathResource pathTea = new ClassPathResource("datasImages/tisane.png");
			try (InputStream inputStream = pathTea.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();
				MultipartFile imageTea = new MockMultipartFile("file", pathTea.getFilename(), "image/png", imageData);
				productService.saveProduct(tisaneRelaxante, imageTea);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity makeUpBioFermeFournier = new Activity();
			makeUpBioFermeFournier.setActivityName("Atelier fabrication de cosmétiques naturels");
			makeUpBioFermeFournier.setActive(true);
			makeUpBioFermeFournier.setActivityDescription(
					"Créez vos produits cosmétiques à base d’ingrédients naturels, sans conservateurs nocifs, dans cet atelier accessible à tous.");
			makeUpBioFermeFournier.setDateTime(java.sql.Date.valueOf("2025-02-20"));
			makeUpBioFermeFournier.setStartTime(LocalTime.of(14, 0));
			makeUpBioFermeFournier.setEndTime(LocalTime.of(16, 30));
			makeUpBioFermeFournier.setLocation("Ferme Fournier, Salle des Ateliers");
			makeUpBioFermeFournier.setDuration(150);
			makeUpBioFermeFournier.setPrice(35.00);
			makeUpBioFermeFournier.setAvailableSpots(20);
			makeUpBioFermeFournier.setRemainingSpots(20);
			makeUpBioFermeFournier.setRegisteredMembers(0);
			makeUpBioFermeFournier.setProducer(fermeFournier);

			ClassPathResource makeUpActivityPath = new ClassPathResource("datasImages/a9.jpg");
			try (InputStream inputStream = makeUpActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imagemakeUpActivity = new MockMultipartFile("file", makeUpActivityPath.getFilename(),
						"image/jpg", imageData);

				activityService.save(makeUpBioFermeFournier, imagemakeUpActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity cookingWithFermeFournier = new Activity();
			cookingWithFermeFournier.setActivityName("Cueillette sauvage et cuisine");
			cookingWithFermeFournier.setActive(true);
			cookingWithFermeFournier.setActivityDescription(
					"Partez à la découverte des plantes comestibles locales et apprenez à les cuisiner dans des recettes simples et savoureuses.");
			cookingWithFermeFournier.setDateTime(java.sql.Date.valueOf("2025-02-28"));
			cookingWithFermeFournier.setStartTime(LocalTime.of(14, 0));
			cookingWithFermeFournier.setEndTime(LocalTime.of(16, 30));
			cookingWithFermeFournier.setLocation("Ferme Fournier, Salle des Ateliers");
			cookingWithFermeFournier.setDuration(150);
			cookingWithFermeFournier.setPrice(35.00);
			cookingWithFermeFournier.setAvailableSpots(20);
			cookingWithFermeFournier.setRemainingSpots(20);
			cookingWithFermeFournier.setRegisteredMembers(0);
			cookingWithFermeFournier.setProducer(fermeFournier);

			ClassPathResource cookingActivityPath = new ClassPathResource("datasImages/a11.jpg");
			try (InputStream inputStream = cookingActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageCookingActivity = new MockMultipartFile("file", cookingActivityPath.getFilename(),
						"image/jpg", imageData);

				activityService.save(makeUpBioFermeFournier, imageCookingActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity breadBakingWorkshop = new Activity();
			breadBakingWorkshop.setActivityName("Atelier de fabrication de pain au levain");
			breadBakingWorkshop.setActive(true);
			breadBakingWorkshop.setActivityDescription(
					"Découvrez les secrets du pain au levain et apprenez à réaliser votre propre pain artisanal, de la pâte à la cuisson.");
			breadBakingWorkshop.setDateTime(java.sql.Date.valueOf("2025-03-15"));
			breadBakingWorkshop.setStartTime(LocalTime.of(10, 0));
			breadBakingWorkshop.setEndTime(LocalTime.of(13, 0));
			breadBakingWorkshop.setLocation("Ferme Fournier, Four à Bois");
			breadBakingWorkshop.setDuration(180);
			breadBakingWorkshop.setPrice(40.00);
			breadBakingWorkshop.setAvailableSpots(15);
			breadBakingWorkshop.setRemainingSpots(15);
			breadBakingWorkshop.setRegisteredMembers(0);
			breadBakingWorkshop.setProducer(fermeFournier);

			ClassPathResource breadActivityPath = new ClassPathResource("datasImages/a1.jpg");
			try (InputStream inputStream = breadActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageBreadActivity = new MockMultipartFile("file", breadActivityPath.getFilename(),
						"image/jpg", imageData);

				activityService.save(breadBakingWorkshop, imageBreadActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity herbalTeaWorkshop = new Activity();
			herbalTeaWorkshop.setActivityName("Atelier préparation de tisanes bio");
			herbalTeaWorkshop.setActive(true);
			herbalTeaWorkshop.setActivityDescription(
					"Apprenez à reconnaître les plantes médicinales et à préparer des tisanes bénéfiques pour votre santé.");
			herbalTeaWorkshop.setDateTime(java.sql.Date.valueOf("2025-03-22"));
			herbalTeaWorkshop.setStartTime(LocalTime.of(15, 0));
			herbalTeaWorkshop.setEndTime(LocalTime.of(17, 30));
			herbalTeaWorkshop.setLocation("Ferme Fournier, Salle des Herbes");
			herbalTeaWorkshop.setDuration(150);
			herbalTeaWorkshop.setPrice(30.00);
			herbalTeaWorkshop.setAvailableSpots(20);
			herbalTeaWorkshop.setRemainingSpots(20);
			herbalTeaWorkshop.setRegisteredMembers(0);
			herbalTeaWorkshop.setProducer(fermeFournier);

			ClassPathResource herbalTeaActivityPath = new ClassPathResource("datasImages/a18.jpg");
			try (InputStream inputStream = herbalTeaActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageHerbalTeaActivity = new MockMultipartFile("file",
						herbalTeaActivityPath.getFilename(), "image/jpg", imageData);

				activityService.save(herbalTeaWorkshop, imageHerbalTeaActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity cheeseMakingWorkshop = new Activity();
			cheeseMakingWorkshop.setActivityName("Atelier fabrication de fromage fermier");
			cheeseMakingWorkshop.setActive(true);
			cheeseMakingWorkshop.setActivityDescription(
					"Découvrez les étapes de fabrication du fromage fermier et repartez avec votre propre création.");
			cheeseMakingWorkshop.setDateTime(java.sql.Date.valueOf("2025-04-05"));
			cheeseMakingWorkshop.setStartTime(LocalTime.of(9, 0));
			cheeseMakingWorkshop.setEndTime(LocalTime.of(12, 30));
			cheeseMakingWorkshop.setLocation("Ferme Fournier, Laiterie");
			cheeseMakingWorkshop.setDuration(210);
			cheeseMakingWorkshop.setPrice(50.00);
			cheeseMakingWorkshop.setAvailableSpots(12);
			cheeseMakingWorkshop.setRemainingSpots(12);
			cheeseMakingWorkshop.setRegisteredMembers(0);
			cheeseMakingWorkshop.setProducer(fermeFournier);

			ClassPathResource cheeseActivityPath = new ClassPathResource("datasImages/a7.jpg");
			try (InputStream inputStream = cheeseActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageCheeseActivity = new MockMultipartFile("file", cheeseActivityPath.getFilename(),
						"image/jpg", imageData);

				activityService.save(cheeseMakingWorkshop, imageCheeseActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity potteryWorkshop = new Activity();
			potteryWorkshop.setActivityName("Atelier de poterie artisanale");
			potteryWorkshop.setActive(true);
			potteryWorkshop.setActivityDescription(
					"Initiez-vous à la poterie artisanale et créez vos propres objets uniques dans cet atelier convivial.");
			potteryWorkshop.setDateTime(java.sql.Date.valueOf("2025-04-12"));
			potteryWorkshop.setStartTime(LocalTime.of(14, 0));
			potteryWorkshop.setEndTime(LocalTime.of(17, 0));
			potteryWorkshop.setLocation("Ferme Fournier, Atelier de Création");
			potteryWorkshop.setDuration(180);
			potteryWorkshop.setPrice(45.00);
			potteryWorkshop.setAvailableSpots(10);
			potteryWorkshop.setRemainingSpots(10);
			potteryWorkshop.setRegisteredMembers(0);
			potteryWorkshop.setProducer(fermeFournier);

			ClassPathResource potteryActivityPath = new ClassPathResource("datasImages/a26.png");
			try (InputStream inputStream = potteryActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imagePotteryActivity = new MockMultipartFile("file", potteryActivityPath.getFilename(),
						"image/png", imageData);

				activityService.save(potteryWorkshop, imagePotteryActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity jamMakingWorkshop = new Activity();
			jamMakingWorkshop.setActivityName("Atelier de fabrication de confitures");
			jamMakingWorkshop.setActive(true);
			jamMakingWorkshop.setActivityDescription(
					"Apprenez à préparer des confitures artisanales avec des fruits frais et repartez avec vos pots personnalisés.");
			jamMakingWorkshop.setDateTime(java.sql.Date.valueOf("2025-04-19"));
			jamMakingWorkshop.setStartTime(LocalTime.of(10, 0));
			jamMakingWorkshop.setEndTime(LocalTime.of(13, 0));
			jamMakingWorkshop.setLocation("Ferme Fournier, Cuisine Partagée");
			jamMakingWorkshop.setDuration(180);
			jamMakingWorkshop.setPrice(35.00);
			jamMakingWorkshop.setAvailableSpots(15);
			jamMakingWorkshop.setRemainingSpots(15);
			jamMakingWorkshop.setRegisteredMembers(0);
			jamMakingWorkshop.setProducer(fermeFournier);

			ClassPathResource jamActivityPath = new ClassPathResource("datasImages/a190.png");
			try (InputStream inputStream = jamActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageJamActivity = new MockMultipartFile("file", jamActivityPath.getFilename(),
						"image/png", imageData);

				activityService.save(jamMakingWorkshop, imageJamActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Activity vegetableGardeningWorkshop = new Activity();
			vegetableGardeningWorkshop.setActivityName("Atelier jardinage de légumes bio");
			vegetableGardeningWorkshop.setActive(true);
			vegetableGardeningWorkshop.setActivityDescription(
					"Apprenez les bases du jardinage biologique pour cultiver vos propres légumes frais et sains.");
			vegetableGardeningWorkshop.setDateTime(java.sql.Date.valueOf("2025-04-26"));
			vegetableGardeningWorkshop.setStartTime(LocalTime.of(9, 30));
			vegetableGardeningWorkshop.setEndTime(LocalTime.of(12, 30));
			vegetableGardeningWorkshop.setLocation("Ferme Fournier, Jardin de Formation");
			vegetableGardeningWorkshop.setDuration(180);
			vegetableGardeningWorkshop.setPrice(30.00);
			vegetableGardeningWorkshop.setAvailableSpots(20);
			vegetableGardeningWorkshop.setRemainingSpots(20);
			vegetableGardeningWorkshop.setRegisteredMembers(0);
			vegetableGardeningWorkshop.setProducer(fermeFournier);

			ClassPathResource gardeningActivityPath = new ClassPathResource("datasImages/a43.png");
			try (InputStream inputStream = gardeningActivityPath.getInputStream()) {
				byte[] imageData = inputStream.readAllBytes();

				MultipartFile imageGardeningActivity = new MockMultipartFile("file",
						gardeningActivityPath.getFilename(), "image/png", imageData);

				activityService.save(vegetableGardeningWorkshop, imageGardeningActivity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Basket panierFruitsFermeFournier = new Basket();
			panierFruitsFermeFournier.setName("Panier de fruits bio");
			panierFruitsFermeFournier.setActive(true);
			panierFruitsFermeFournier.setDescription("Un assortiment de fruits frais et de saison, cultivés sans pesticides. Idéal pour une alimentation saine.");
			panierFruitsFermeFournier.setBasketType(Basket.basketType.fruit);
			panierFruitsFermeFournier.setPublished(true);
			panierFruitsFermeFournier.setPrice(25.00);
			panierFruitsFermeFournier.setStock(50);
			panierFruitsFermeFournier.setProducer(fermeFournier);

			ClassPathResource fruitBasketImagePath = new ClassPathResource("datasImages/fruitsBasket1.png");

			try (InputStream inputStream = fruitBasketImagePath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();

			    MultipartFile imageFruitBasket = new MockMultipartFile("file", fruitBasketImagePath.getFilename(), "image/png", imageData);

			    basketService.save(panierFruitsFermeFournier, imageFruitBasket);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			Basket panierFruitsFournier1 = new Basket();
			panierFruitsFournier1.setName("Panier de fruits d'été");
			panierFruitsFournier1.setActive(true);
			panierFruitsFournier1.setDescription("Un mélange rafraîchissant de fruits d'été : pêches, abricots et cerises.");
			panierFruitsFournier1.setBasketType(Basket.basketType.fruit);
			panierFruitsFournier1.setPublished(true);
			panierFruitsFournier1.setPrice(20.00);
			panierFruitsFournier1.setStock(30);
			panierFruitsFournier1.setProducer(fermeFournier);

			ClassPathResource fruitsSummerPath = new ClassPathResource("datasImages/fruitsSummer.png");
			try (InputStream inputStream = fruitsSummerPath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile fruitsSummerImage = new MockMultipartFile("file", fruitsSummerPath.getFilename(), "image/png", imageData);
			    basketService.save(panierFruitsFournier1, fruitsSummerImage);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			Basket panierLegumesDurteint1 = new Basket();
			panierLegumesDurteint1.setName("Panier de légumes racines");
			panierLegumesDurteint1.setActive(true);
			panierLegumesDurteint1.setDescription("Un assortiment de légumes racines : carottes, pommes de terre, betteraves.");
			panierLegumesDurteint1.setBasketType(Basket.basketType.veggie);
			panierLegumesDurteint1.setPublished(true);
			panierLegumesDurteint1.setPrice(18.00);
			panierLegumesDurteint1.setStock(40);
			panierLegumesDurteint1.setProducer(vergerDurteint);

			ClassPathResource legumesRacinesPath = new ClassPathResource("datasImages/legumesRacines.png");
			try (InputStream inputStream = legumesRacinesPath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile legumesRacinesImage = new MockMultipartFile("file", legumesRacinesPath.getFilename(), "image/png", imageData);
			    basketService.save(panierLegumesDurteint1, legumesRacinesImage);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			Basket panierMixFournier1 = new Basket();
			panierMixFournier1.setName("Panier mixte gourmet");
			panierMixFournier1.setActive(true);
			panierMixFournier1.setDescription("Un panier mélangeant fruits et légumes bio pour des repas équilibrés.");
			panierMixFournier1.setBasketType(Basket.basketType.mix);
			panierMixFournier1.setPublished(true);
			panierMixFournier1.setPrice(25.00);
			panierMixFournier1.setStock(20);
			panierMixFournier1.setProducer(fermeFournier);

			ClassPathResource mixGourmetPath = new ClassPathResource("datasImages/mixGourmet.png");
			try (InputStream inputStream = mixGourmetPath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile mixGourmetImage = new MockMultipartFile("file", mixGourmetPath.getFilename(), "image/png", imageData);
			    basketService.save(panierMixFournier1, mixGourmetImage);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			Basket panierFruitsDurteint1 = new Basket();
			panierFruitsDurteint1.setName("Panier de fruits d'automne");
			panierFruitsDurteint1.setActive(true);
			panierFruitsDurteint1.setDescription("Des fruits d'automne savoureux : pommes, poires et raisins.");
			panierFruitsDurteint1.setBasketType(Basket.basketType.fruit);
			panierFruitsDurteint1.setPublished(true);
			panierFruitsDurteint1.setPrice(22.00);
			panierFruitsDurteint1.setStock(35);
			panierFruitsDurteint1.setProducer(vergerDurteint);

			ClassPathResource fruitsAutumnPath = new ClassPathResource("datasImages/fruitsAutumn.png");
			try (InputStream inputStream = fruitsAutumnPath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile fruitsAutumnImage = new MockMultipartFile("file", fruitsAutumnPath.getFilename(), "image/png", imageData);
			    basketService.save(panierFruitsDurteint1, fruitsAutumnImage);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			Basket panierLegumesFournier1 = new Basket();
			panierLegumesFournier1.setName("Panier de légumes de saison");
			panierLegumesFournier1.setActive(true);
			panierLegumesFournier1.setDescription("Un assortiment varié de légumes de saison cultivés localement.");
			panierLegumesFournier1.setBasketType(Basket.basketType.veggie);
			panierLegumesFournier1.setPublished(true);
			panierLegumesFournier1.setPrice(19.00);
			panierLegumesFournier1.setStock(50);
			panierLegumesFournier1.setProducer(fermeFournier);

			ClassPathResource legumesSeasonPath = new ClassPathResource("datasImages/legumesSeason.png");
			try (InputStream inputStream = legumesSeasonPath.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile legumesSeasonImage = new MockMultipartFile("file", legumesSeasonPath.getFilename(), "image/png", imageData);
			    basketService.save(panierLegumesFournier1, legumesSeasonImage);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			Amap agrinov = new Amap("Agrinov", "Route des Parquets 95390 Saint-Prix", "Roy", "Alexia", "0198400087",
					"aroy@agrinov.fr", "root123!", "123 456 789 00012");
			
			Timestamp timestampAgrinovPayment = Timestamp.valueOf("2024-12-22 11:10:06.211000");
			
			agrinov.setSubLastPaymentDate(timestampAgrinovPayment);
			agrinov.setSubscription(basicSubscription);
			
			Timestamp timestampAgrinov = Timestamp.valueOf("2024-12-22 11:10:06.211000");
			agrinov.setDateCreated(timestampAgrinov);
			
			agrinov.setAboutSectionTitle("À propos de nous ...");
			agrinov.setAboutSectionText("Agrinov, fondée en 2018, est une AMAP résolument tournée vers l’avenir. Nous unissons innovation et tradition pour bâtir une agriculture durable et solidaire. Située en périphérie urbaine, Agrinov connecte les citadins aux agriculteurs locaux à travers des produits cultivés avec soin et respect de l’environnement.<br><br>"
					+ "Notre mission est de répondre aux besoins alimentaires d’aujourd’hui tout en préservant les ressources pour demain. Chaque panier Agrinov est une promesse : celle d’une alimentation saine, de saison et produite dans une logique de circuit court. Nos partenaires agricoles, sélectionnés pour leurs pratiques écoresponsables, s’engagent à cultiver et élever dans des conditions favorables à la biodiversité.<br><br>"
					+ "Rejoindre Agrinov, c’est faire partie d’une initiative collaborative où chaque adhérent est acteur de la transition écologique. Participez à nos rencontres, nos ateliers éducatifs, et ensemble, construisons un avenir alimentaire innovant et respectueux des générations futures.");
			
			agrinov.setSubSectionTitle("Fonctionnement des abonnements paniers");
			agrinov.setSubSectionText("L’abonnement chez Agrinov se veut flexible et adapté à votre mode de vie. Vous pouvez choisir parmi plusieurs tailles de paniers et personnaliser votre abonnement selon vos besoins : panier standard, spécial fruits, ou encore panier végétarien. L’engagement est saisonnier (3 mois) avec des options de retrait hebdomadaires ou mensuelles.<br><br>"
					+ "Les paniers sont disponibles tous les samedis matin de 9h à 12h dans notre point de retrait principal, situé près de la ferme pédagogique d’Agrinov. Un mail de rappel vous est envoyé la veille pour vous assurer de ne pas oublier votre panier. Si vous êtes indisponible, nous offrons la possibilité de reporter votre retrait ou de le faire livrer à un voisin solidaire.<br><br>"
					+ "En rejoignant Agrinov, vous accédez à une alimentation locale, fraîche et savoureuse, tout en participant activement à un modèle agricole innovant et responsable.");
			
			amapAccountService.save(agrinov);
			
			Member marie = new Member("Marie", "Dupont", "marie@ferme-dupont.com", "producer123!",
			        "10 chemin des Prairies 95390 Saint-Prix", "0176543210", new Date(), new Date(), agrinov,
			        MemberType.PRODUCER);
			marie.setMemberShipFee(true);
			marie.setAccountStatus(true);

			Producer fermeDupont = new Producer();
			fermeDupont.setProducerCompanyName("Ferme Dupont");
			fermeDupont.setProducerSiret("321 654 987 00021");
			marie.setProducer(fermeDupont);

			memberService.save(marie);

			Member paul = new Member("Paul", "Bertrand", "paul@verger-bertrand.com", "producer123!",
			        "8 avenue des Pommiers 95390 Saint-Prix", "0169875432", new Date(), new Date(), agrinov,
			        MemberType.PRODUCER);
			paul.setMemberShipFee(true);
			paul.setAccountStatus(true);

			Producer vergerBertrand = new Producer();
			vergerBertrand.setProducerCompanyName("Verger Bertrand");
			vergerBertrand.setProducerSiret("123 987 654 00056");
			paul.setProducer(vergerBertrand);

			memberService.save(paul);
			
			
			//
			Basket panierMarieFruits = new Basket();
			panierMarieFruits.setName("Panier Fruits de Saison");
			panierMarieFruits.setActive(true);
			panierMarieFruits.setDescription("Un assortiment de fruits frais bio cultivés avec soin.");
			panierMarieFruits.setBasketType(Basket.basketType.fruit);
			panierMarieFruits.setPublished(true);
			panierMarieFruits.setPrice(22.50);
			panierMarieFruits.setStock(50);
			panierMarieFruits.setProducer(fermeDupont);

			ClassPathResource marieFruitsImage = new ClassPathResource("datasImages/panierFruitsMarie.png");
			try (InputStream inputStream = marieFruitsImage.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile imageMarieFruits = new MockMultipartFile("file", marieFruitsImage.getFilename(), "image/png", imageData);
			    basketService.save(panierMarieFruits, imageMarieFruits);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			Basket panierMarieLegumes = new Basket();
			panierMarieLegumes.setName("Panier Légumes Croquants");
			panierMarieLegumes.setActive(true);
			panierMarieLegumes.setDescription("Des légumes croquants et bio parfaits pour vos repas.");
			panierMarieLegumes.setBasketType(Basket.basketType.veggie);
			panierMarieLegumes.setPublished(true);
			panierMarieLegumes.setPrice(25.00);
			panierMarieLegumes.setStock(40);
			panierMarieLegumes.setProducer(fermeDupont);

			ClassPathResource marieLegumesImage = new ClassPathResource("datasImages/panierLegumesMarie.png");
			try (InputStream inputStream = marieLegumesImage.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile imageMarieLegumes = new MockMultipartFile("file", marieLegumesImage.getFilename(), "image/png", imageData);
			    basketService.save(panierMarieLegumes, imageMarieLegumes);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			Basket panierMarieMixte = new Basket();
			panierMarieMixte.setName("Panier Duo Fruité");
			panierMarieMixte.setActive(true);
			panierMarieMixte.setDescription("Un mélange parfait de fruits et légumes bio.");
			panierMarieMixte.setBasketType(Basket.basketType.mix);
			panierMarieMixte.setPublished(true);
			panierMarieMixte.setPrice(28.00);
			panierMarieMixte.setStock(35);
			panierMarieMixte.setProducer(fermeDupont);

			ClassPathResource marieMixteImage = new ClassPathResource("datasImages/panierMixteMarie.png");
			try (InputStream inputStream = marieMixteImage.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile imageMarieMixte = new MockMultipartFile("file", marieMixteImage.getFilename(), "image/png", imageData);
			    basketService.save(panierMarieMixte, imageMarieMixte);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			Basket panierMarieGourmand = new Basket();
			panierMarieGourmand.setName("Panier Gourmand Exotique");
			panierMarieGourmand.setActive(true);
			panierMarieGourmand.setDescription("Un panier rempli de fruits exotiques pour une touche d'évasion.");
			panierMarieGourmand.setBasketType(Basket.basketType.fruit);
			panierMarieGourmand.setPublished(true);
			panierMarieGourmand.setPrice(30.00);
			panierMarieGourmand.setStock(20);
			panierMarieGourmand.setProducer(fermeDupont);

			ClassPathResource marieGourmandImage = new ClassPathResource("datasImages/panierExotiqueMarie.png");
			try (InputStream inputStream = marieGourmandImage.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile imageMarieGourmand = new MockMultipartFile("file", marieGourmandImage.getFilename(), "image/png", imageData);
			    basketService.save(panierMarieGourmand, imageMarieGourmand);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			Basket panierMarieVitalite = new Basket();
			panierMarieVitalite.setName("Panier Vitalité Bio");
			panierMarieVitalite.setActive(true);
			panierMarieVitalite.setDescription("Un panier équilibré pour une alimentation saine.");
			panierMarieVitalite.setBasketType(Basket.basketType.mix);
			panierMarieVitalite.setPublished(true);
			panierMarieVitalite.setPrice(26.50);
			panierMarieVitalite.setStock(30);
			panierMarieVitalite.setProducer(fermeDupont);

			ClassPathResource marieVitaliteImage = new ClassPathResource("datasImages/panierVitaliteMarie.png");
			try (InputStream inputStream = marieVitaliteImage.getInputStream()) {
			    byte[] imageData = inputStream.readAllBytes();
			    MultipartFile imageMarieVitalite = new MockMultipartFile("file", marieVitaliteImage.getFilename(), "image/png", imageData);
			    basketService.save(panierMarieVitalite, imageMarieVitalite);
			} catch (IOException e) {
			    e.printStackTrace();
			}

			
			//end
			
			
		}

	}
}
