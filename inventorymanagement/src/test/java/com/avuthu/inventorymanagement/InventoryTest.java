package com.avuthu.inventorymanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.avuthu.inventorymanagement.serice.InventoryService;

public class InventoryTest {
	
	@Test
	public void execute() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("transactions.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				new InventoryService().processRequest(scanner.nextLine());
			}
			Assert.assertEquals(""
					, -724.75
					,InventoryRepository.getInstance().getHistReportPnlList().get(1).getProfit()
					, 0.1);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
