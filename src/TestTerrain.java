public class TestTerrain{
	public static void main(String[] args){
		Terrain terrain = new Terrain(30,4);
		terrain.init();
		terrain.pointHaut();
		//terrain.strates();
		terrain.strates2();
		System.out.println(terrain.toString());
		System.out.println(terrain.toString2());
		
	}
}