sap.ui.define(["sap/ui/core/mvc/Controller",
	"jquery.sap.global",
	"sunil/util/service", "sap/m/MessageBox"], function(Controller, jQuery, Service, MessageBox) {
	return Controller.extend("sunil.controller.Main", {
		
		onInit: function() {
			var oJsonModel = new sap.ui.model.json.JSONModel();
			
			oJsonModel.setData({
				"postPayLoad" : {
					"companyName": "",
					"firstName": "",
					"lastName": "",
					"website": "",
					"email": "",
					"status": "A",
					"gstNo": ""
				}
			});
			
			sap.ui.getCore().setModel(oJsonModel);

		},
		
		getItemToDelete: function(oEvent) {
			var idSelected = oEvent.getSource().getSelectedItem().getAggregation("cells")[0].getProperty("text");
			sap.ui.getCore().getModel().setProperty("/IdForDeletion", idSelected);
		},
		
		onDeletion: function() {
			Service.callService("/vendorDelete", "Delete", sap.ui.getCore().getModel().getProperty("/IdForDeletion")).then(function(response){
				MessageBox.show("Record Deleted successfully");				
			}.bind(this)).catch(function(oError) {
				MessageBox.error("Record failed to Delete");
			});
		},
		
		onSaveData: function() {
			Service.callService("/vendorPost", "Post", sap.ui.getCore().getModel().getProperty("/postPayLoad")).then(function(response){
				MessageBox.show("Record saved successfully");				
			}.bind(this)).catch(function(oError) {
				MessageBox.error("Record failed to save");
			});
		},
		
		onLoadData: function() {
			Service.callService("/vendor", "GET").then(function(data){
				
				var oModel = new sap.ui.model.json.JSONModel();
				oModel.setData(data);
				
				this.getView().setModel(oModel, "vendDet");				
			}.bind(this)).catch(function(oError) {
			});
						
		}
		
	});
});