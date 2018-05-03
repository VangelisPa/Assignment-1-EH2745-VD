package Assignment1;

//Importing the required libraries for parsing data from XML files
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

//The PaesingXML class is created for extracting all the required data through defined method
public class ParsingXML {
	
	//Creating array list for each CIM object according to individual classes defined per object
	public static  ArrayList <BaseVoltClass> BaseVoltageList = new ArrayList<BaseVoltClass>();
	public static  ArrayList <SubstationClass> SubstationList = new ArrayList<SubstationClass>();
	public static  ArrayList <VoltLevelClass> VoltLevelList = new ArrayList<VoltLevelClass>();
	public static  ArrayList <GenUnitClass> GenUnitList = new ArrayList<GenUnitClass>();
	public static  ArrayList <SynchMachineClass> SynchMachineList = new ArrayList<SynchMachineClass>();
	public static  ArrayList <RegControlClass> RegCtrList = new ArrayList<RegControlClass>();
	public static  ArrayList <PowerTransClass> PowerTrList = new ArrayList<PowerTransClass>();
	public static  ArrayList <LoadClass> LoadList = new ArrayList<LoadClass>();
	public static  ArrayList <PowTrEndClass> TransWindList = new ArrayList<PowTrEndClass>();
	public static  ArrayList <BreakerClass> BreakerList = new ArrayList<BreakerClass>();
	public static  ArrayList <TapChangerClass> TapChangerList = new ArrayList<TapChangerClass>();
	public static  ArrayList <TerminalClass> TerminalList = new ArrayList<TerminalClass>();
	public static  ArrayList <ConnectivityNodeClass> ConnectNodeList = new ArrayList<ConnectivityNodeClass>();
	public static  ArrayList <ACLineClass> ACLineList = new ArrayList<ACLineClass>();
	public static  ArrayList <BusBarClass> BusBarList = new ArrayList<BusBarClass>();
	public static  ArrayList <ShuntClass> ShuntList = new ArrayList<ShuntClass>();
	

public class Assignment_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
