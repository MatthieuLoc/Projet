import java.util.ArrayList;

public class TestTerrain{
	public static void main(String[] args){
		int delai = 200;//100; // -- delay before refreshing display -- program is hold during delay, even if no screen update was requested. USE WITH CARE. 

		Terrain terrain = new Terrain(30,4);
		terrain.init();
		terrain.pointHaut();
		//terrain.strates();
		terrain.strates2();
		terrain.ajoutArbres();
		System.out.println(terrain.toString());
		System.out.println(terrain.toString2());
		System.out.println(terrain.toString3());
		

		
		for(;;){
			
		}
		

	}
}