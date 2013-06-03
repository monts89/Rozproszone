/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computing.methods;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mati
 */
// dla listy argumentow 
public class Arguments
{
    private String name;
    private double value;
    
    public Arguments() throws IOException
    {
        // poki co tak a potem mozna by z interfesju wczytywac ilosc itd
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe parametru ");
        name = reader.readLine(); 
        System.out.println("Podaj wartosc ");
        value = Double.parseDouble(reader.readLine());
    }
    
    public Arguments(String name, double value)
    {
        this.name = name;
        this.value = value;
    }
    
    public String get_argument_name()
    {
        return this.name;
    }
    
    public double get_argument_value()
    {
        return this.value;
    }
    
}
