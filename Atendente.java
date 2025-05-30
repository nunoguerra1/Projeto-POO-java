// Aluno : Nuno Guerra - RA : a2706504
public class Atendente extends Pessoa implements CalcSalario{

	private float salario;
	private float bonus;
	private String turno;
	private int totalVendas;
	private float valorTotalVendas;

	public Atendente(){
		salario = 0.0f;
		bonus = 0.0f;
		turno = "";
		totalVendas = 0;
		valorTotalVendas = 0.0f;
	}

	public void salarioTotal(){
		float salarioTotal = (salario + bonus);
		System.out.println("Salario total..: "+salarioTotal+"R$");
	}

	public float getSalario(){
		return salario;
	}

	public float getBonus(){
		return bonus;
	}

	public String getTurno(){
		return turno;
	}

	public int getTotalVendas(){
		return totalVendas;
	}

	public float getValorTotalVendas(){
		return valorTotalVendas;
	}

	public void setSalario(float salario) throws SalarioMinException{
		if (salario < 1518){
			throw new SalarioMinException();
		}
		
		this.salario = salario;
	}

	public void setBonus(float bonus){
		this.bonus = bonus;
	}

	public void setTurno(String turno) throws TurnoNumException{
		if (turno.matches(".*\\d.*")) {
			throw new TurnoNumException();
		}

		this.turno = turno;	

	}

	public void setTotalVendas(int totalVendas){
		this.totalVendas = totalVendas;
	}

	public void setValorTotalVendas(float valorTotalVendas){
		this.valorTotalVendas = valorTotalVendas;
	}


}