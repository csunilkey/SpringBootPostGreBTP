sap.ui.define(["jquery.sap.global"], function(Jquery) {
	return {
		callService: function(url, method, payload) {
			
			return new Promise(function(resolve, reject) {
				
				switch(method.toUpperCase()) {
					case "GET":
						jQuery.ajax(url, {
							type: method,
							success: function(data, oResponse) {
								resolve(data);															
							}.bind(this),
							error: function(oError) {
								reject(oError);
							}
						});
						break;
					
					case "POST":						
						jQuery.ajax(url, {
							type: method,
							data: JSON.stringify(payload),
							headers: { 
						        'Accept': 'application/json',	// for service to understand type of data to send to client
						        'Content-Type': 'application/json'  // for service to expect type of data from client
						    },
						    dataType: "json",
							success: function(oResponse) {
								resolve(oResponse);
							},
							error: function(oError) {
								reject(oError);
							}
						});
						break;
						
					case "DELETE":
						jQuery.ajax(url + "/" + payload, {
							type: method,
							success: function(oResponse) {
								resolve(oResponse);
							},
							error: function(oError) {
								reject(oError);
							}
						});
						break;
				}
								
			});			
		}
	}
});