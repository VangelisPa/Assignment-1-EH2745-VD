package Assignment1;

//Importing the required libraries for parsing data from XML files
import java.io.File;

import java.sql.*;
import javax.swing.*;  
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import javax.swing.table.TableColumn;
import java.awt.Font;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

//The PaesingXML class is created for extracting all the required data through defined method
public class Assignment_main{
	
	//Creating array list for each CIM object according to individual classes defined per object
	public static  ArrayList <BaseVoltage> BaseVoltageList = new ArrayList<BaseVoltage>();
	public static  ArrayList <Substation> SubstationList = new ArrayList<Substation>();
	public static  ArrayList <VoltageLevel> VoltLevelList = new ArrayList<VoltageLevel>();
	public static  ArrayList <GeneratingUnit> GenUnitList = new ArrayList<GeneratingUnit>();
	public static  ArrayList <SynchronousMachine> SynchMachineList = new ArrayList<SynchronousMachine>();
	public static  ArrayList <RegulatingControl> RegCtrList = new ArrayList<RegulatingControl>();
	public static  ArrayList <PowerTransformer> PowerTrList = new ArrayList<PowerTransformer>();
	public static  ArrayList <PowerTransformerEnd> TransWindList = new ArrayList<PowerTransformerEnd>();
	public static  ArrayList <Breaker> BreakerList = new ArrayList<Breaker>();
	public static  ArrayList <RatioTapChanger> TapChangerList = new ArrayList<RatioTapChanger>();
	public static  ArrayList <Terminal> TerminalList = new ArrayList<Terminal>();
	public static  ArrayList <ConnectivityNode> ConnectNodeList = new ArrayList<ConnectivityNode>();
	public static  ArrayList <ACLineSegment> ACLineList = new ArrayList<ACLineSegment>();
	public static  ArrayList <Busbar> BusBarList = new ArrayList<Busbar>();
	public static  ArrayList <Shunt> ShuntList = new ArrayList<Shunt>();
	
	// The general method for parsing the CIM data and return them as a array list for each CIM object
	public void parsingMethod(String EQ, String SSH) {
		
		try {
			//The files we are going to parse now named XMLFileEQ/SSH
			File XmlFileEQ = new File(EQ);
			File XmlFileSSH = new File(SSH);
					
			//We create the Document object and parse them
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document docEQ = dBuilder.parse(XmlFileEQ);
			Document docSSH = dBuilder.parse(XmlFileSSH);
					 
			// Return root element of the file and normalize XML files
			docEQ.getDocumentElement().normalize();
			docSSH.getDocumentElement().normalize();
					 
			// The next step is to extract information 
					 
			// Extract required data from the EQ file
			NodeList baseVoltList = docEQ.getElementsByTagName("cim:BaseVoltage");
			NodeList subList = docEQ.getElementsByTagName("cim:Substation");
			NodeList voltList = docEQ.getElementsByTagName("cim:VoltageLevel");
			NodeList genList = docEQ.getElementsByTagName("cim:GeneratingUnit");
			NodeList syncList = docEQ.getElementsByTagName("cim:SynchronousMachine");
			NodeList regList = docEQ.getElementsByTagName("cim:RegulatingControl");
			NodeList powTrList = docEQ.getElementsByTagName("cim:PowerTransformer");
			NodeList energyConList = docEQ.getElementsByTagName("cim:EnergyConsumer");
			NodeList powTrEndList = docEQ.getElementsByTagName("cim:PowerTransformerEnd");
			NodeList breakList = docEQ.getElementsByTagName("cim:Breaker");
			NodeList tapList = docEQ.getElementsByTagName("cim:RatioTapChanger");
			 
			// EQ for the YBUS
			NodeList terminalList = docEQ.getElementsByTagName("cim:Terminal");
			NodeList CNodeList = docEQ.getElementsByTagName("cim:ConnectivityNode");
			NodeList LineList = docEQ.getElementsByTagName("cim:ACLineSegment");
			NodeList busList = docEQ.getElementsByTagName("cim:BusbarSection");
			NodeList shuntList = docEQ.getElementsByTagName("cim:LinearShuntCompensator");
				 
			// Extract required data from the SSH file
			NodeList syncListSSH = docSSH.getElementsByTagName("cim:SynchronousMachine");
			NodeList regListSSH = docSSH.getElementsByTagName("cim:RegulatingControl");
			NodeList energyConListSSH = docSSH.getElementsByTagName("cim:EnergyConsumer");
			NodeList breakListSSH = docSSH.getElementsByTagName("cim:Breaker");
			NodeList tapListSSH = docSSH.getElementsByTagName("cim:RatioTapChanger");
			
			     
			//Base Voltage List
			for (int i = 0; i<baseVoltList.getLength(); i++) {
				BaseVoltage baseV = new BaseVoltage();
				baseV.extractNode(baseVoltList.item(i));
				BaseVoltageList.add(baseV);
				}
			// Substation List
	        for (int i = 0; i<subList.getLength(); i++) {							
				Substation substation = new Substation();
				substation.extractNode(subList.item(i));
				SubstationList.add(substation);							
				}
	        //Voltage Level List
			for (int i = 0; i<voltList.getLength(); i++) {
				VoltageLevel voltLevel = new VoltageLevel();
				voltLevel.extractNode(voltList.item(i));
				VoltLevelList.add(voltLevel);
				}
			//Generating Unit List
			for (int i = 0; i<genList.getLength(); i++) {
				GeneratingUnit genUnit = new GeneratingUnit();
				genUnit.extractNode(genList.item(i));
				GenUnitList.add(genUnit);
				}
			//Synchronous Machine List
			for (int i = 0; i<syncList.getLength(); i++) {
				SynchronousMachine synchMach = new SynchronousMachine();
				synchMach.extractNode(syncList.item(i));
				synchMach.extractNodeSSH(syncListSSH.item(i));
				SynchMachineList.add(synchMach);
				}
			//Regulating Control List
			for (int i = 0; i<regList.getLength(); i++) {
				RegulatingControl regCtrl = new RegulatingControl();
				regCtrl.extractNode(regList.item(i));
				regCtrl.extractNodeSSH(regListSSH.item(i));
				RegCtrList.add(regCtrl);	
				}
			//Power Transformer List
			for (int i = 0; i<powTrList.getLength(); i++) {
				PowerTransformer PowTrans = new PowerTransformer();
				PowTrans.extractNode(powTrList.item(i));
				PowerTrList.add(PowTrans);
				}
			//Energy Consumer List
			for (int i = 0; i<energyConList.getLength(); i++) {
				LoadClass load = new LoadClass();
				load.extractNode(energyConList.item(i));
				load.extractNodeSSH(energyConListSSH.item(i));
				LoadList.add(load);
				}
		    //Power Transformer End (Winding) List
			for (int i = 0; i<powTrEndList.getLength(); i++) {
				PowerTransformerEnd transEnd = new PowerTransformerEnd();
				transEnd.extractNode(powTrEndList.item(i));
				TransWindList.add(transEnd);
				}
			//Breaker List
			for (int i = 0; i<breakList.getLength(); i++) {
				Breaker breaker = new Breaker();
				breaker.extractNode(breakList.item(i));
				breaker.extractNodeSSH(breakListSSH.item(i));
				BreakerList.add(breaker);
				}
			//Ratio Tap Changer List
			for (int i = 0; i<tapList.getLength(); i++) {
				TapChanger tapChng = new TapChanger();
				tapChng.extractNode(tapList.item(i));
				tapChng.extractNodeSSH(tapListSSH.item(i));
				TapChangerList.add(tapChng);
			}
			
			//// For YBUS matrix			     
				  //Terminal List
					for (int i = 0; i<terminalList.getLength(); i++) {
						TerminalClass terminal = new TerminalClass();
						terminal.extractNode(terminalList.item(i));
						TerminalList.add(terminal);
						}
				  //Connectivity Node List
					for (int i = 0; i<CNodeList.getLength(); i++) {
						ConnectivityNodeClass ConNode = new ConnectivityNodeClass();
						ConNode.extractNode(CNodeList.item(i));
						ConnectNodeList.add(ConNode);
						}
				  //AC Line List
					for (int i = 0; i<LineList.getLength(); i++) {
						ACLineClass line = new ACLineClass();
						line.extractNode(LineList.item(i));
						ACLineList.add(line);
						}
				  //BusBar List
					for (int i = 0; i<busList.getLength(); i++) {
						BusBarClass bus = new BusBarClass();
						bus.extractNode(busList.item(i));
						BusBarList.add(bus);
						}
				  //Linear Shunt Compensator List
					for (int i = 0; i<shuntList.getLength(); i++) {
						ShuntClass shunt = new ShuntClass();
						shunt.extractNode(shuntList.item(i));
						ShuntList.add(shunt);
						}
																
		}
		catch(Exception e){
			e.printStackTrace();
			}
		}
	
	//Returning the list of array for each CIM objects
	public List <BaseVoltage> getBaseVoltList(){
		return BaseVoltageList;
	}
	public List <Substation> getSubList(){
		return SubstationList;
	}
	public List <VoltageLevel> getVoltList(){
		return VoltLevelList;
	}
	public List <GeneratingUnit> getGenUnitList(){
		return GenUnitList;
	}
	public List <SynchronousMachine> getSynchMachList(){
		return SynchMachineList;
	}
	public List <RegulatingControl> getRegCtrList(){
		return RegCtrList;
	}
	public List <PowerTransformer> getPowTrList(){
		return PowerTrList;
	}
	public List <LoadClass> getLoadList(){
		return LoadList;
	}
	public List <PowerTransformerEnd> getTrWindList(){
		return TransWindList;
	}
	public List <Breaker> getBreakerList(){
		return BreakerList;
	}
	public List <TapChanger> getTapChngList(){
		return TapChangerList;
	}
	public List <Terminal> getTerminalList(){
		return TerminalList;
	}
	public List <ConnectivityNode> getConNodeList(){
		return ConnectNodeList;
	}
	public List <ACLineSegment> getACLineList(){
		return ACLineList;
	}
	public List <BusBar> getBusBarList(){
		return BusBarList;
	}
	public List <Shunt> getShuntList(){
		return ShuntList;
	}
}
