import models.Endereco;
import models.Temperatura;

import java.util.Scanner;

public class Principal {

        public static void main(String[] args) throws Exception {

            System.out.print("Informe sua Cidade: ");
            String cidade = new Scanner(System.in).nextLine();
            Temperatura temperatura = ServicoTemperatura.buscarTemperaturaPorCidade(cidade);

            System.out.println("Base: " + temperatura.getBase());
            System.out.println("Visibilidade: " + temperatura.getVisibility());
            System.out.println("Temperatura: " + temperatura.getMain().getTemp());



//            System.out.print("Informe seu CEP: ");
//            String cep = new Scanner(System.in).nextLine();
//            Endereco endereco = ServicoCep.buscaEnderecoPelo(cep);
//
//            System.out.println("Logradouro: " + endereco.getLogradouro());
//            System.out.println("Bairro: " + endereco.getBairro());
//            System.out.println("Localidade: " + endereco.getLocalidade());
//            System.out.println("Estado: " + endereco.getUf());




        }

    }

