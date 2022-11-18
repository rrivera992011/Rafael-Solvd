class Main {

	public final static void main (String [] args){
	
		Car car = new Car();
		car.setColor(args[0]);
		String carColor = car.getColor();
		
		System.out.println(carColor);
	
	}

}

class Car {
		private String color;
		private int productionYear;
		private float maxSpeed;
		
		public void setColor(String color) {
			this.color = color;
		}
		
		public String getColor() {
		
			return this.color;
		}
}