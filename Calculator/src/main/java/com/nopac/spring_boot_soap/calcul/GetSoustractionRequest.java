//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.13 à 11:52:25 PM CET 
//


package com.nopac.spring_boot_soap.calcul;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="valeur1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valeur2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "valeur1",
    "valeur2"
})
@XmlRootElement(name = "getSoustractionRequest")
public class GetSoustractionRequest {

    protected int valeur1;
    protected int valeur2;

    /**
     * Obtient la valeur de la propriété valeur1.
     * 
     */
    public int getValeur1() {
        return valeur1;
    }

    /**
     * Définit la valeur de la propriété valeur1.
     * 
     */
    public void setValeur1(int value) {
        this.valeur1 = value;
    }

    /**
     * Obtient la valeur de la propriété valeur2.
     * 
     */
    public int getValeur2() {
        return valeur2;
    }

    /**
     * Définit la valeur de la propriété valeur2.
     * 
     */
    public void setValeur2(int value) {
        this.valeur2 = value;
    }

}
