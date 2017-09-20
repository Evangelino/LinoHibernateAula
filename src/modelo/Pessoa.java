package modelo;

import javax.persistence.*;

/**
 *
 * @author Evangelino
 */

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    int id;
    String nome;
    int idade;
    String morada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Nome: "+getNome()+"\nId: "+getId()+"\nMorada: "+getMorada()+"\nIdade: "+getIdade();
    }
    

}
