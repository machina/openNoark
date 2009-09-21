unzip -u emf2gorm/lib/groovy-all-1.7-beta-1-SNAPSHOT.jar -d emf2gorm/bin/
cp -rf emf2gormGroovy/bin/no emf2gorm/bin/
jar cmvf emf2gorm/META-INF/MANIFEST.MF emf2gorm.jar -C  emf2gorm icons -C emf2gorm plugin.xml -C emf2gorm/bin/ .  
