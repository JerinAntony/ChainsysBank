//click
//change
//blur
$(document).ready(
		function() {
			
			$('#bankName').change(
					function() {
						$('#branchname').empty();
						console.log($('#bankName').val());
						$.ajax({
							url : 'Branch',
							data : {
								bankname : $('#bankName').val(),
							},
							success : function(responseText) {
								var branchlist = "";
								branchlist = responseText.split(',');
								$('#branchname').append(
										"<option value=''>Select Branch"
												+ "</option>");
								for ( var item in branchlist) {
									$('#branchname').append(
											"<option value=" + branchlist[item]
													+ ">" + branchlist[item]
													+ "</option>");
								}
							}
						});
					});
		});