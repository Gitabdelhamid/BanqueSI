var app=angular.module("MyBanque",[]);

app.controller("BanqueController",function($scope,$http){
$scope.codeCompte="";
$scope.codeEmploye=2;
$scope.montant=0;
$scope.clients=[];
$scope.employes=[];
$scope.messages="";
$scope.verser=function(){
$http.put("/versement?codeCompte="+$scope.codeCompte+"&montant="+
		$scope.montant+"&codeEmplye="+$scope.codeEmploye)
		.success(function(data){
			$scope.codeCompte="";
			$scope.montant=0;
			$scope.messages="Vessement effecuer avec succes !";
			
});
};
$scope.retirer=function(){
	$http.put("/retrait?codeCompte="+$scope.codeCompte+"&montant="+
			$scope.montant+"&codeEmplye="+$scope.codeEmploye)
			.success(function(data){
				$scope.codeCompte="";
				$scope.montant=0;
				$scope.messages="Retrait effecuer avec succes !";
				alert("Retrait effecuer avec succes !");
				
	});
	};
	
	$scope.AllClient=function(){
		$http.get("/clients")
				.success(function(data){
					$scope.clients=data;
					
		});
		};
		$scope.AllEmployee=function(){
			$http.get("/employes")
					.success(function(data){
						$scope.employes=data;
						
			});
			};
		$scope.initL = function () {
			// traitement à effectuer au chargement de la page
			$http.get("/clients").success(function(data){$scope.clients=data;});
			$http.get("/employes").success(function(data){$scope.employes=data;});
			};

});

app.controller("BillCtrl", function($scope){
    $scope.articles = [{"name": "Téléphone sans-fil", "quantity": 1, "price": "29.99"}, {"name": "Chargeur iPhone6", "quantity": 1, "price": "29.99"}];
    $scope.total = function(){
        var total = 0;
        for(var i = 0; i < $scope.articles.length; i++){
            total += $scope.articles[i].price * $scope.articles[i].quantity;
        }
        return total;
    };
    function calculateDiscount(newValue, oldValue, scope){
        $scope.discount = (newValue > 100) ? newValue * 0.10 : 0;
    };
    
    $scope.finalTotal = function(){
        return $scope.total() - $scope.discount;   
    };
    
    $scope.$watch($scope.total, calculateDiscount);
});