------------------ READ ME ----------------------

A chaque lancement d'Eclipse :

	- Pull
	
	
Pour mettre à jour un fichier :

	-Commit & Push


En cas d'erreur "non fast-forward" ou ajouter quelque chose pour la première fois :
	
	- Pull
	- Merge Tool
	- Sur les fichiers en conflit : Add to Index
	- Commit & Push
	
Pour ajouter une fichier :
	
	-Add to intex
	-Commit & Push

Situation:

	- You have local uncommitted changes
	- You pull from the master repo
	- You get the error "Checkout conflict with files: xy"
Solution:

	- Stage and commit (at least) the files xy
	- Pull again
	- If automerge is possible, everything is ok.
	- If not, the pull merges the files and inserts the merge-conflict markers (<<<<<<, >>>>)
	- Manually edit the conflicting files
	- Commit and push