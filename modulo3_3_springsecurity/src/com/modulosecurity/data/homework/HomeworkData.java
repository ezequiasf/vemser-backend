package com.modulosecurity.data.homework;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class HomeworkData
{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
//        exercicio1();
//        exercicio2();
//        exercicio3();
//        exercicio4();
//        Exercicio5.formatadorApp();
//        exercicio6();
    }

    public static void exercicio1()
    {
        LocalDate hoje = LocalDate.now();
        System.out.println("Informe o dia do seu aniversário: ");
        int diaAniversario = sc.nextInt();
        System.out.println("Agora informe o mês: ");
        int mesAniversario = sc.nextInt();
        int anoConsideracao = hoje.getYear();
        int mesHoje = hoje.getMonth().getValue();
        if (!(mesHoje<mesAniversario)){
            if (mesHoje == mesAniversario){
                if (hoje.getDayOfMonth()>diaAniversario){
                    anoConsideracao +=1;
                }
            }else{
                anoConsideracao +=1;
            }
        }
        LocalDate aniversarioUsuario = LocalDate.of(anoConsideracao, mesAniversario, diaAniversario);
        Period distancia = Period.between(aniversarioUsuario, hoje);
        System.out.printf("Estamos a %d meses e %d dias do seu aniversário!"
                , Math.abs(distancia.getMonths()), Math.abs(distancia.getDays()));
    }

    public static void exercicio2()
    {
        System.out.println("|Calculadora de períodos|");
        System.out.println("Informe uma data inicial no seguinte formato (ano-mes-dia):");
        LocalDate dataInicial = LocalDate.parse(sc.nextLine());
        System.out.println("Informe uma data final no seguinte formato (ano-mes-dia):");
        LocalDate dataFinal = LocalDate.parse(sc.nextLine());
        Period periodo = Period.between(dataInicial, dataFinal);
        System.out.printf("Diferença das datas:%nAnos:%d%nMeses:%d%nDias:%d", periodo.getYears()
                , periodo.getMonths(), periodo.getDays());
    }

    static void exercicio3()
    {
        LocalTime horaBrasilEast = LocalTime.now(ZoneId.of("Brazil/East"));
        LocalTime horaAustraliaSidney = LocalTime.now(ZoneId.of("Australia/Sydney"));
        LocalTime horaJapao = LocalTime.now(ZoneId.of("Japan"));
        LocalTime horaRussiaMoscow = LocalTime.now(ZoneId.of("Europe/Moscow"));
        LocalTime horaDubai = LocalTime.now(ZoneId.of("Asia/Dubai"));
        LocalTime horaUSDakota = LocalTime.now(ZoneId.of("America/North_Dakota/Center"));
        System.out.printf("Hora nas seguintes regiões:%nBrasil:\t%s%nAustrália(Sidney):\t%s%n" +
                        "Japão:\t%s%nRússia(Moscow):\t%s%nDubai:\t%s%nUS(North Dakota):\t%s", horaBrasilEast,
                horaAustraliaSidney, horaJapao, horaRussiaMoscow, horaDubai, horaUSDakota);
    }

    public static void exercicio4()
    {
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        LocalDateTime dataPosterior = dataHoraAgora.plusDays(15).plusHours(10);
        System.out.printf("Dia da semana daqui a 15 dias: %s%nDia corrido no ano: %d"
                , dataPosterior.getDayOfWeek().getDisplayName(TextStyle.FULL
                        , new Locale("pt", "BR"))
                , dataPosterior.getDayOfYear());
    }

    static class Exercicio5
    {
        static void formatadorApp()
        {
            System.out.println("Formatador>>>>>");
            System.out.println("Insira uma data: formato (yyyy-MM-dd)");
            LocalDate dataInicial = LocalDate.parse(sc.nextLine());
            String brasil = new Exercicio5().formatadorData(dataInicial, new Locale("pt", "BR"));
            String franca = new Exercicio5().formatadorData(dataInicial, Locale.FRANCE);
            String us = new Exercicio5().formatadorData(dataInicial, Locale.US);
            System.out.printf("Formato de data:%nBrasil:\t%s%nFrança:\t%s%nEstados Unidos:\t%s"
                    , brasil, franca, us);
        }

        String formatadorData(LocalDate data, Locale local)
        {
            return data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                    .withLocale(local));
        }
    }

    public static void exercicio6()
    {
        ZonedDateTime dateTimeBrasil = LocalDateTime.now()
                .atZone(ZoneId.of("Brazil/East"));
        ZonedDateTime dateTimeLondon = LocalDateTime.of(2024, 9, 14, 18, 30)
                .atZone(ZoneId.of("Europe/London"));
        long difOffset = dateTimeLondon.getOffset().getTotalSeconds() - dateTimeBrasil.getOffset().getTotalSeconds();
        Period periodo = Period.between(dateTimeBrasil.toLocalDate(), dateTimeLondon.toLocalDate());
        Duration duracao = Duration.between(dateTimeLondon.minusSeconds(difOffset).toLocalTime(), dateTimeBrasil.toLocalTime());
        long hour = duracao.abs().toHours();
        long minutes = duracao.abs().toMinutes() % 60;
        long seconds = duracao.abs().getSeconds() % 60;
        System.out.printf("Faltam %d anos, %d meses, %d dias, %d horas, %d minutos, %d segundos para o " +
                        "épico show de wesley safadão!!", periodo.getYears(), periodo.getMonths()
                , periodo.getDays(), hour, minutes, seconds);
    }
}
