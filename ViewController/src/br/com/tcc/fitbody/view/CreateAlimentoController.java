package br.com.tcc.fitbody.view;

import br.com.tcc.fitbody.model.utils.JSFUtils;

import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.output.RichActiveOutputText;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.render.ClientEvent;


public class CreateAlimentoController {
    private RichInputNumberSpinbox qtdProteinas;
    private RichInputNumberSpinbox qtdCarboidratos;
    private RichInputNumberSpinbox qtdLipidios;
    private RichInputNumberSpinbox pesoTotal;
    private RichInputText nomeAlimento;

    public CreateAlimentoController() {
    }
    
/*
 * Actions
 */
 
/*
 * Listeners
 */
    
    public void listenerPesoConsiderado(ValueChangeEvent event) {
        if(event.getNewValue()!=event.getOldValue()){
            double pesoFull = convertToDouble(pesoTotal.getValue());
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtProteinas"))
                .setValue(calcularMacroPorGrama(pesoFull," • Proteinas (1g): ",
                                                convertToDouble(qtdProteinas.getValue())));
 
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtCarboidratos"))
                .setValue(calcularMacroPorGrama(pesoFull," • Carboidratos (1g): ",
                                                convertToDouble(qtdCarboidratos.getValue())));
  
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtLipidios"))
                .setValue(calcularMacroPorGrama(pesoFull," • Lipidios (1g): ",
                                                convertToDouble(qtdLipidios.getValue())));
        }
    }    

    public void listenerSpinProteina(ValueChangeEvent event) {
        if(event.getNewValue()!=event.getOldValue()){
            double pesoFull = convertToDouble(pesoTotal.getValue());
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtProteinas"))
                .setValue(calcularMacroPorGrama(pesoFull," • Proteinas (1g): ",
                                                convertToDouble(qtdProteinas.getValue())));            
        }
    }

    public void listenerSpinCarboidrato(ValueChangeEvent event) {
        if(event.getNewValue()!=event.getOldValue()){
            double pesoFull = convertToDouble(pesoTotal.getValue());
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtCarboidratos"))
                .setValue(calcularMacroPorGrama(pesoFull," • Carboidratos (1g): ",
                                                convertToDouble(qtdCarboidratos.getValue())));        
        }
    }

    public void listenerSpinLipidio(ValueChangeEvent event) {
        if(event.getNewValue()!=event.getOldValue()){
            double pesoFull = convertToDouble(pesoTotal.getValue());
            ((RichActiveOutputText)JSFUtils.findComponentInRoot("txtLipidios"))
                .setValue(calcularMacroPorGrama(pesoFull," • Lipidios (1g): ",
                                                convertToDouble(qtdLipidios.getValue())));            
        }
    }    

    public void preRenderAddVitaminasPage(ComponentSystemEvent componentSystemEvent) {
        ((RichInputText)JSFUtils.findComponentInRoot("it1")).setValue("teste");
        System.out.println("Peso a considerar: "
                      +String.format("%.2f",convertToDouble(pesoTotal.getValue())));
    }

/*
 * Metodos Auxiliares
 */
    
    private double convertToDouble(Object obj){
       return Double.parseDouble(obj.toString());
    }

    private String calcularMacroPorGrama(double pesoTotal,String customFrase, double valorMacro){
        double valor =  valorMacro / pesoTotal;
        return customFrase+String.format("%.2f", valor);
    }

/*
 * Getters e Setters
 */
    
    public void setQtdProteinas(RichInputNumberSpinbox qtdProteinas) {
        this.qtdProteinas = qtdProteinas;
    }

    public RichInputNumberSpinbox getQtdProteinas() {
        return qtdProteinas;
    }

    public void setQtdCarboidratos(RichInputNumberSpinbox qtdCarboidratos) {
        this.qtdCarboidratos = qtdCarboidratos;
    }

    public RichInputNumberSpinbox getQtdCarboidratos() {
        return qtdCarboidratos;
    }

    public void setQtdLipidios(RichInputNumberSpinbox qtdLipidios) {
        this.qtdLipidios = qtdLipidios;
    }

    public RichInputNumberSpinbox getQtdLipidios() {
        return qtdLipidios;
    }

    public void setPesoTotal(RichInputNumberSpinbox pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public RichInputNumberSpinbox getPesoTotal() {
        return pesoTotal;
    }

    public void setNomeAlimento(RichInputText nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public RichInputText getNomeAlimento() {
        return nomeAlimento;
    }
}
