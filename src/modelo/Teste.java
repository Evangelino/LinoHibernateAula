package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Evangelino
 */
public class Teste {

    public static void criar(ArrayList dados) {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        dados.forEach(p -> {
            session.save(p);

        });
        session.getTransaction().commit();
        session.close();
        sf.close();
    }

    public static ArrayList lerDados() {
        ArrayList dados = new ArrayList();
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria crietrio = session.createCriteria(Pessoa.class);
        dados.addAll(crietrio.list());

        session.getTransaction();
        session.close();
        sessionFactory.close();

        return dados;

    }

    public static void remover(Object o) {
        ArrayList dados = new ArrayList();
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(o);
        session.flush();
        session.close();

    }

    public static void atualizar(Object o) {
        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();

        sessao.saveOrUpdate(o);

        sessao.getTransaction().commit();
        sessao.close();
        e.close();

    }

    public static void apagarDados(Object o) {
        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();

        sessao.delete(o);
        sessao.flush();

        sessao.getTransaction().commit();
        sessao.close();
        e.close();

    }

    public static void main(String[] args) {
//        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        Session sessao = sessionFactory.openSession();
//        sessao.beginTransaction();
//
//        Pessoa people = new Pessoa();
//        people.setNome("Ladrao");
//        people.setId(0);
//        people.setIdade(12);
//        people.setMorada("Coop");
//
//        sessao.save(people);
//        sessao.getTransaction().commit();
//        sessao.delete(people);
//        sessao.flush();
//        sessao.close();
//        sessionFactory.close();

        ArrayList dados = new ArrayList();
        int i = 1;
        Pessoa p = new Pessoa();
        do {

            String nome = JOptionPane.showInputDialog("Introduz  o nome da pessoa");
            p.setNome(nome);
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Introduz o idade da pessoa"));
            p.setIdade(idade);
            String morada = JOptionPane.showInputDialog("Introduz  o morada da pessoa");
            p.setMorada(morada);
            dados.add(p);
            criar(dados);
            i = Integer.parseInt(JOptionPane.showInputDialog("Seleccione a opcao\n"
                    + "0-->  Finalizar\n"
                    + "1-->  Criar"));

        } while (i != 0);
        lerDados().forEach(n -> {
            JOptionPane.showMessageDialog(null, n.toString());
        });

        //Deletar Pessoa
        int k = Integer.parseInt(JOptionPane.showInputDialog("Seleccione o ID da pessoa que deseja apagar"));
        p.setId(k);
        remover(p);

        //Editar
        int v = Integer.parseInt(JOptionPane.showInputDialog("Introduza o ID da pessoa a editar"));
        p.setId(v);
        String nome = JOptionPane.showInputDialog("Introduz  o nome da pessoa");
        p.setNome(nome);
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Introduz o idade da pessoa"));
        p.setIdade(idade);
        String morada = JOptionPane.showInputDialog("Introduz  o morada da pessoa");
        p.setMorada(morada);
        dados.add(p);
        atualizar(p);

    }

}
