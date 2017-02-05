(ns snw.data)

(def stats [:str :con :dex :int :wis :cha])

(def classes
  [{:name :assassin
    :prime-attrs #{:dex :str :int}
    :health {:hd 6
             :hd-until 13
             :start-hd 1
             :extra-hp 1}}
   {:name :cleric
    :prime-attrs #{:wis}
    :health {:hd 6
             :hd-until 9
             :start-hd 1
             :extra-hp 1}
    :spells {:cleric
             {2  [1]
              3  [2]
              4  [2 1]
              5  [2 2]
              6  [2 2 1 1]
              7  [2 2 2 1 1]
              8  [2 2 2 2 2]
              9  [3 3 3 2 2]
              10 [3 3 3 3 3]
              11 [4 4 4 3 3]
              12 [4 4 4 4 4 1]
              13 [5 5 5 4 4 1]
              14 [5 5 5 5 5 2]
              15 [6 6 6 5 5 2]
              16 [6 6 6 6 6 3]
              17 [7 7 7 6 6 3 1]
              18 [7 7 7 7 7 4 1]
              19 [8 8 8 7 7 4 2]
              20 [8 8 8 8 8 5 2]
              21 [9 9 9 8 8 5 3]}}}
   {:name :druid
    :prime-attrs #{:wis :cha}
    :health {:hd 6
             :hd-until 9
             :start-hd 1
             :extra-hp 1}
    :spells {:druid
             {1  [1]
              2  [2 1]
              3  [3 1]
              4  [3 1 1]
              5  [3 2 1]
              6  [3 2 2]
              7  [4 2 2 1]
              8  [4 3 2 1]
              9  [4 3 3 2]
              10 [5 3 3 2 1]
              11 [5 3 3 3 2 1]
              12 [5 4 4 4 3 2 1]
              13 [6 5 5 4 4 3 2]
              14 [7 5 5 4 4 3 2]
              15 [7 6 5 4 4 3 2]
              16 [7 6 6 4 4 3 2]
              17 [8 6 6 5 4 3 2]
              18 [8 7 6 5 5 3 2]
              19 [9 8 6 5 5 3 2]
              20 [9 8 7 5 5 3 2]
              21 [9 8 7 6 5 3 2]}}}
   {:name :fighter
    :prime-attrs #{:str}
    :health {:hd 8
             :hd-until 9
             :start-hd 1
             :extra-hp 2}}
   {:name :magicuser
    :prime-attrs #{:int}
    :health {:hd 4
             :hd-until 11
             :start-hd 1
             :extra-hp 1}
    :spells {:magicuser
             {1  [1]
              2  [2]
              3  [2 1]
              4  [3 2]
              5  [4 2 1]
              6  [4 2 2]
              7  [4 3 2 1]
              8  [4 3 3 2]
              9  [4 3 3 2 1]
              10 [4 4 3 2 2]
              11 [4 4 4 3 3]
              12 [4 4 4 4 4 1]
              13 [5 5 5 4 4 2]
              14 [5 5 5 4 4 3 1]
              15 [5 5 5 5 4 4 2]
              16 [5 5 5 5 5 5 2 1]
              17 [6 6 6 5 5 5 2 2]
              18 [6 6 6 6 6 5 2 2 1]
              19 [7 7 7 6 6 6 3 2 2]
              20 [7 7 7 7 7 7 3 3 2]
              21 [8 8 8 7 7 7 4 3 3]}}}
   {:name :monk
    :prime-attrs #{:wis}
    :health {:hd 4
             :hd-until 16
             :start-hd 1
             :extra-hp 1}}
   {:name :paladin
    :prime-attrs #{:str}
    :health {:hd 8
             :hd-until 9
             :start-hd 1
             :extra-hp 2}}
   {:name :ranger
    :prime-attrs #{:str}
    :health {:hd 8
             :hd-until 9
             :start-hd 2
             :extra-hp 2}
    :spells {:cleric
             {9 [1]
              10 [2 1]
              11 [2 1]
              12 [3 2 1]
              13 [3 2 1]
              14 [4 3 1]
              15 [4 3 1]
              16 [4 3 2]
              17 [4 3 2]
              18 [5 4 2]
              19 [5 4 2]
              20 [5 4 3]
              21 [5 4 3]}
             :magicuser
             {10 [1]
              11 [2 1]
              12 [2 1]
              13 [3 2 1]
              14 [3 2 1]
              15 [4 3 1]
              16 [4 3 1]
              17 [4 3 2]
              18 [4 3 2]
              19 [5 4 2]
              20 [5 4 2]
              21 [5 4 3]}}}
   {:name :thief
    :prime-attrs #{:dex}
    :health {:hd 4
             :hd-until 10
             :start-hd 1
             :extra-hp 1}}
   ])

(def name->class (into {} (map (juxt :name identity) classes)))

(def spells
  {:magicuser
   {1 ["Charm Person"
       "Detect Magic"
       "Hold Portal"
       "Light"
       "Magic Missile"
       "Protection from Evil"
       "Read Languages"
       "Read Magic"
       "Shield"
       "Sleep"]
    2 ["Continual Light"
       "Darkness, 15-foot Radius"
       "Detect Evil"
       "Detect Invisibility"
       "ESP"
       "Invisibility"
       "Knock"
       "Levitate"
       "Locate Object"
       "Magic Mouth"
       "Mirror Image"
       "Phantasmal Force"
       "Pyrotechnics"
       "Stinking Cloud"
       "Strength"
       "Web"
       "Wizard Lock"]
    3 ["Clairaudience"
       "Clairvoyance"
       "Darkvision"
       "Dispel Magic"
       "Explosive Runes"
       "Fireball"
       "Fly"
       "Haste"
       "Hold Person"
       "Invisibility, 10-foot Radius"
       "Lightning Bolt"
       "Monster Summoning I"
       "Protection from Evil, 10-foot Radius"
       "Protection from Normal Missiles"
       "Rope Trick"
       "Slow"
       "Suggestion"
       "Water Breathing"]
    4 ["Charm Monster"
       "Confusion"
       "Dimension Door"
       "Extension I"
       "Fear"
       "Hallucinatory Terrain"
       "Ice Storm"
       "Massmorph"
       "Monster Summoning II"
       "Plant Growth"
       "Polymorph Other"
       "Polymorph Self"
       "Remove Curse"
       "Wall of Fire"
       "Wall of Ice"
       "Wizard Eye"]
    5 ["Animal Growth"
       "Animate Dead"
       "Cloudkill"
       "Conjuration of Elementals"
       "Contact Other"
       "Plane Extension II"
       "Feeblemind"
       "Hold Monster"
       "Magic Jar"
       "Monster Summoning III"
       "Passwall"
       "Telekinesis"
       "Teleport"
       "Transmute Rock to Mud"
       "Wall of Iron"
       "Wall of Stone"]
    6 ["Anti-Magic Shell"
       "Control Weather"
       "Death Spell"
       "Disintegrate"
       "Enchant Item"
       "Geas"
       "Invisible Stalker"
       "Legend Lore"
       "Lower Water"
       "Monster Summoning IV"
       "Move Earth"
       "Part Water"
       "Project Image"
       "Reincarnation"
       "Repulsion"
       "Stone to Flesh"]
    7 ["Charm Plants"
       "Conjuration of Demons"
       "Delayed Blast"
       "Fireball"
       "Extension III"
       "Limited Wish"
       "Mass Invisibility"
       "Monster Summoning V"
       "Phase Door"
       "Power Word, Stun"
       "Reverse Gravity"
       "Simulacrum"]
    8 ["Clone"
       "Mass Charm"
       "Mind Blank"
       "Monster Summoning VI"
       "Permanency"
       "Polymorph Object"
       "Power Word, Blind"
       "Symbol"]
    9 ["Astral Spell"
       "Maze"
       "Gate"
       "Meteor Swarm"
       "Monster Summoning VII"
       "Power Word, Kill"
       "Prismatic Sphere"
       "Shape Change"
       "Time Stop"
       "Wish"]}
  :druid
  {1 ["Detect Magic"
      "Detect Snares & Pits"
      "Faerie Fire"
      "Locate Animals"
      "Predict Weather"
      "Purify Water"]
   2 ["Create Water"
      "Cure Light Wounds"
      "Heat Metal"
      "Locate Plants"
      "Obscuring Mist"
      "Produce Flame"
      "Speak with Animals"
      "Warp Wood"]
   3 ["Call Lightning"
      "Cure Disease"
      "Hold Animal"
      "Neutralize Poison"
      "Plant Growth"
      "Protection Against Fire"
      "Pyrotechnics"
      "Water Breathing"]
   4 ["Animal Summoning I"
      "Control Temperature 10-ft. Radius"
      "Cure Serious Wounds"
      "Dispel Magic"
      "Hallucinatory Forest"
      "Insect Plague"
      "Plant Doorway"
      "Produce Fire"
      "Protection from Lightning"
      "Speak with Plants"]
   5 ["Animal Growth"
      "Animal Summoning II"
      "Anti-Plant Ward"
      "Commune with Nature"
      "Control Winds"
      "Hold Plant"
      "Transmute Rock to Mud"
      "Passplant"
      "Sticks to Snakes"
      "Wall of Fire"]
   6 ["Animal Summoning III"
      "Anti-Animal Ward"
      "Conjuration of Fire Elementals"
      "Feeblemind"
      "Finger of Death"
      "Repel Wood"
      "Transport via Plants"
      "Weather Summoning"]
   7 ["Animate Rock"
      "Confusion"
      "Conjuration of Earth Elementals"
      "Control Weather"
      "Creeping Doom"
      "Fire Storm"
      "Reincarnation"
      "Transmute Metal to Wood"]}
  :cleric
  {1 ["Cure Light Wounds"
      "Detect Evil"
      "Detect Magic"
      "Light"
      "Protection from Evil"
      "Purify Food and Drink"]
   2 ["Bless"
      "Find Traps"
      "Hold Person"
      "Silence, 15-foot Radius"
      "Snake Charm"
      "Speak with Animals"]
   3 ["Continual Light"
      "Cure Disease"
      "Locate Object"
      "Prayer"
      "Remove Curse"
      "Speak with Dead"]
   4 ["Create Water"
      "Cure Serious Wounds"
      "Neutralize Poison"
      "Protection from Evil, 10-foot Radius"
      "Speak with Plants"
      "Sticks to Snakes"]
   5 ["Commune"
      "Create Food"
      "Dispel Evil"
      "Finger of Death"
      "Insect Plague"
      "Quest"
      "Raise Dead"]
   6 ["Animate Object"
      "Blade Barrier"
      "Conjuration of Animals"
      "Find the Path"
      "Speak with Monsters"
      "Word of Recall"]
   7 ["Aerial Servant"
      "Astral Spell"
      "Control Weather"
      "Earthquake"
      "Holy Word"
      "Part Water"
      "Restoration"
      "Resurrection"
      "Symbol"
      "Wind Walk"]}
})
