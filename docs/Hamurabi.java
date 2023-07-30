public class Hammurabi {         // must save in a file named Hammurabi.java
	Random rand = new Random();  // this is an instance variable
	Scanner scanner = new Scanner(System.in);
	private int people;
	private int bushelOfGrain;
	private int acresOfLand;
	private int landValue;

	static Logger logger = Logger.getLogger("Hammurabi.log");

	public static void main(String[] args) {
		@@ -22,16 +19,88 @@ public static void main(String[] args) {

			void playGame() {
				logger.info("The game has started");
				people = 100;
				bushelOfGrain = 28000;
				acresOfLand = 1000;
				landValue = 19;
				int people = 100;
				int bushelOfGrain = 28000;
				int acresOfLand = 1000;
				int landValue = 19;
				int outcome;
				int foodForPeasants;
				//Checks if you want to buy land. If the number is zero or less, it asks if you want to sell land.
				outcome = askHowManyAcresToBuy(landValue, bushelOfGrain);
				if(outcome > 0){
					bushelOfGrain = bushelOfGrain - (outcome * landValue);
					acresOfLand += outcome;
					logger.info("Current Bushels: " + bushelOfGrain + " Acres of Land: " + acresOfLand);
				}else if(outcome <= 0){
					outcome = askHowManyAcresToSell(acresOfLand);
					acresOfLand = acresOfLand - outcome;
					bushelOfGrain = bushelOfGrain + (outcome * landValue);
					logger.info("Current Bushels: " + bushelOfGrain + " Acres of Land: " + acresOfLand);
				}

				//Asks how much grain to feed the peasants
				foodForPeasants = askHowMuchGrainToFeedPeople(bushelOfGrain);
				bushelOfGrain -= foodForPeasants;
				logger.info("Food for the people " + foodForPeasants + " left over grain " + bushelOfGrain);

				//Get how many acres to plant
				outcome = askHowManyAcresToPlant(acresOfLand, people, bushelOfGrain);




			}

			private int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
				String question = "O Great Hammurabi, how many acres would you like to plant? ";
				int outcome;
				while(true) {
					outcome = getNumber(question);
					if (outcome > acresOwned || outcome > (population * 10) || outcome > (bushels / 2)) {
						System.out.println("Oh great Hammurabi, we do not have the resources for that!");
					} else {
						return outcome;
					}
				}

			}